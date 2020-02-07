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
public class Entity {
 
private String name;
private String countryCode;
	
	public Entity() {}
	
	public Entity(String name, String countryCode) {
		this.name = name;
		this.countryCode = countryCode;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountryCode() { 
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	} 

	@Override
	public String toString() { 
		return "entity [name=" + name + ", countryCode=" + countryCode + "]";
	}

    
    
}
