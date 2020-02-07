/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lyonfutureapi.controller.pojoClass;

/**
 *
 * @author randmc
 */
public class Sample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      XmlParserClass paser = new XmlParserClass();
        
        for(BusinessCard card: paser.retrieveXMLelements()){
      System.out.println(paser.CardlistToJsonPrettyPrint(card));
    }
    }
    
}
