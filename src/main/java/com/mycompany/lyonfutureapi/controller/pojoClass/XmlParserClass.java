/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lyonfutureapi.controller.pojoClass;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mgnt.utils.TextUtils;
import com.mycompany.lyonfutureapi.controller.pojoClass.BusinessCard;
import com.mycompany.lyonfutureapi.controller.pojoClass.Entity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 *
 * @author randmc
 */
public class XmlParserClass {

    public ArrayList<BusinessCard> retrieveXMLelements() {
        BusinessCard businessObject;
        Entity entity = null;
        ArrayList<BusinessCard> businessCardlist = new ArrayList<BusinessCard>();
        final String xmlPath = "C:\\Users\\randmc\\Documents\\myxml\\dummy.xml"; // Just change the directory address here
        try {
            File file = new File(xmlPath);
            DocumentBuilderFactory dbf
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("businesscard");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    // query for businesscard:
                    String icd = eElement.getElementsByTagName("participant").item(0).getAttributes().getNamedItem("value").getTextContent().split(":")[0];
                    String enterprise = eElement.getElementsByTagName("participant").item(0).getAttributes().getNamedItem("value").getTextContent().split(":")[1];
                    // query for the Entity:
                    String countryCode = eElement.getElementsByTagName("entity").item(0).getAttributes().getNamedItem("countrycode").getTextContent();
                    String name = eElement.getElementsByTagName("name").item(0).getAttributes().getNamedItem("name").getTextContent();
                    entity = new Entity(name, countryCode);
                    businessObject = new BusinessCard(icd, enterprise, entity);
                    businessCardlist.add(businessObject);
                }
            }
            return businessCardlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return businessCardlist;
    }
    public BusinessCard getById(String icd, String enterpriseNum) {
        BusinessCard bcard = null;
        XmlParserClass parser = new XmlParserClass();
        for (BusinessCard card : parser.retrieveXMLelements()) {
            if (card.getICD().equals(icd) && card.getBusinessNum().equals(enterpriseNum)) {
                bcard = card;
            }
        }
        return bcard;
    }

    public ArrayList<BusinessCard> searchByName(String name) {
        ArrayList<BusinessCard> bcardlist = new ArrayList<>();
        XmlParserClass parser = new XmlParserClass();
        for (BusinessCard card : parser.retrieveXMLelements()) {
            if (card.getEntity().getName().toLowerCase().contains(name.toLowerCase())) {
                bcardlist.add(card);
            }
        }
        return bcardlist;
    }

    public BusinessCard getByName(String name) {
        BusinessCard bcard = null;
        XmlParserClass parser = new XmlParserClass();
        for (BusinessCard card : parser.retrieveXMLelements()) {
            if (card.getEntity().getName().equalsIgnoreCase(name)) {
                bcard = card;
            }
        }
        return bcard;
    }

    public List<String> getData(String keyword) {
        XmlParserClass parser = new XmlParserClass();
        String names = null;
        List<String> matched = new ArrayList<String>();
        for (BusinessCard card : parser.retrieveXMLelements()) {
            names = card.getEntity().getName();
            if(names.toLowerCase().contains(keyword.toLowerCase())){
            matched.add(names);
            }
            
        }
        return matched;
    }
    public String CardlistToJsonPrettyPrint(BusinessCard card) {
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = prettyGson.toJson(card);
        return TextUtils.formatStringToPreserveIndentationForHtml(prettyJson);
    }
}
