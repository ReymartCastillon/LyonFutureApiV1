/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lyonfutureapi.controller.pojoClass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author randmc
 */
public class ExcecutorClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
   Scanner scanInt = new Scanner(System.in);
   XmlParserClass parser = new XmlParserClass();
   

 ObjectMapper mapper = new ObjectMapper();

String json ="";
for(BusinessCard card: parser.retrieveXMLelements()){

    try {
        json = mapper.writeValueAsString(card);
    } catch (JsonProcessingException ex) {
        Logger.getLogger(ExcecutorClass.class.getName()).log(Level.SEVERE, null, ex);
    }
System.out.println("LyonFutureJson = " + json);

}
    }
}
	
    
    

