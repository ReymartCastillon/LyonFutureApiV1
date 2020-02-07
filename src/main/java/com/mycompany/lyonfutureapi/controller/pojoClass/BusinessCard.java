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
public class BusinessCard {
   
    private String ICD;
	private String businessNum;
	private Entity entity;
	
	public BusinessCard(String ICD, String businessNum, Entity entity) {
		this.ICD = ICD;
		this.businessNum = businessNum;
		this.entity = entity;
		
	}

	public String getICD() {
		return ICD;
	}
 


	public void setICD(String iCD) {
		ICD = iCD;
	}



	public String getBusinessNum() {
		return businessNum;
	}


	public void setBusinessNum(String businessNum) { 
		this.businessNum = businessNum;
	}


	public Entity getEntity() {
		return entity;
	}
 
 
	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return "BusinessCard {"+"ICD=" + ICD + ", businessNum=" + businessNum + "," + entity +"}";
	}
	public String toStringSearchName() {
		return "BusinessCard {"+"ICD=" + ICD + ", businessNum=" + businessNum + ", name=" + entity.getName() + ", countryCode="+entity.getCountryCode()+ '\'' +'}';
		
	}

}