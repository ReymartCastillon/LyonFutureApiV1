/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lyonfutureapi.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mgnt.utils.TextUtils;
import com.mycompany.lyonfutureapi.controller.pojoClass.BusinessCard;
import com.mycompany.lyonfutureapi.controller.pojoClass.ExcecutorClass;
import com.mycompany.lyonfutureapi.controller.pojoClass.XmlParserClass;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author randmc
 */
@Controller
public class LyonFutureController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexJsp() {
        return "index";

    }
    
       @RequestMapping(value = "/searchById", method = RequestMethod.GET)
    public String searchByIdJsp() {
        return "seachbyid";

    }
    
         @RequestMapping(value = "/wildsearch", method = RequestMethod.GET)
    public String wildSearchJsp() {
        return "wildsearch";

    }
    
    
        @RequestMapping(value = "/exactSearch", method = RequestMethod.GET)
    public String exactNameSearchJsp() {
        return "exactnamesearch";

    }
    
     
        @RequestMapping(value = "/home", method = {RequestMethod.GET,RequestMethod.POST})
    public String homeJsp() {
        return "index"; 

    }
     

    @RequestMapping(value = "/searchById/{ICD}/{enterpriseNumber}/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getByIdService(@PathVariable("ICD") String icd,
            @PathVariable("enterpriseNumber") String enterprisenumber,
            ModelMap model,
            HttpServletRequest request) {
        XmlParserClass parser = new XmlParserClass();
        String json = parser.CardlistToJsonPrettyPrint(parser.getById(icd, enterprisenumber));
        
return "BusinessCard "+json;
        }
    
     @RequestMapping(value = "/searchById/{ICD}/{enterpriseNumber}/table", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String getByIdTableService(@PathVariable("ICD") String icd,
            @PathVariable("enterpriseNumber") String enterprisenumber,
            ModelMap model,
            HttpServletRequest request) {
        XmlParserClass parser = new XmlParserClass();
        BusinessCard card = parser.getById(icd, enterprisenumber);
       model.put("icd", card.getICD());
       model.put("enterprise", card.getBusinessNum());
       model.put("name", card.getEntity().getName());
       model.put("code", card.getEntity().getCountryCode());
       
return "idtable";
        }
   
      @RequestMapping(value = "/wildSearch/{keyword}/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
      @ResponseBody
      public String searchByNameService(@PathVariable("keyword") String keyword,
            ModelMap model,
            HttpServletRequest request) {
        XmlParserClass parser = new XmlParserClass();
   Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = prettyGson.toJson(parser.searchByName(keyword));
      
return   TextUtils.formatStringToPreserveIndentationForHtml(prettyJson);
        }
      
           
      @RequestMapping(value = "/wildSearch/{keyword}/table", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
      public String searchByNameTableService(@PathVariable("keyword") String keyword,
            HttpServletRequest request) {
        XmlParserClass parser = new XmlParserClass();
     request.setAttribute("cards", parser.searchByName(keyword));      
return "wildsearchtable";
        }
        
      
             
      @RequestMapping(value = "/exactSearch/{name}/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
      @ResponseBody
      public String getByNameService(@PathVariable("name") String name,
            ModelMap model,
            HttpServletRequest request) {
        XmlParserClass parser = new XmlParserClass();
   String json = "BusinessCard "+parser.CardlistToJsonPrettyPrint(parser.getByName(name));
     if(parser.getByName(name)  == null){
     return "String not found";
     } 
     return json;
        }
      
      
     @RequestMapping(value = "/exactSearch/{name}/table", method = RequestMethod.GET, produces = "application/html; charset=utf-8")
    public String getByNameTableService(@PathVariable("name") String name,
            ModelMap model,
            HttpServletRequest request) {
        XmlParserClass parser = new XmlParserClass();
        BusinessCard card = parser.getByName(name);
      if(card == null){
      model.put("error", "String not found!");
      }else{
       model.put("icd", card.getICD());
       model.put("enterprise", card.getBusinessNum());
       model.put("name", card.getEntity().getName());
       model.put("code", card.getEntity().getCountryCode());
      }
return "exactname";
        }
    
    
  
    }
