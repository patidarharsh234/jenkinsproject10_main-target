package com.rays.vehicle;

import java.util.Date;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_vehicleDTO")
public class vehicleDTO extends BaseDTO{

	

//	number (String),
//	3. purchaseDate,
//	4. insuranceAmount
//	5. Colour (preload)

	
	
	
	@Column(name = "NUMBER", length = 500) // 1
	private String number;
	
	
	
	@Column(name = "INSURANCE_AMOUNT") // 1
	private double insuranceAmount;

	
	@Column(name = "PURCHASE_DATE") // 1
	private Date purchaseDate;
	

	
	
	//role
	
	@Column(name = "Colour", length = 500) // 1
	private String colour;
	
	@Column(name = "ColourId") // 1
	private Long colourId;






	


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public double getInsuranceAmount() {
		return insuranceAmount;
	}


	public void setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public Long getColourId() {
		return colourId;
	}


	public void setColourId(Long colourId) {
		this.colourId = colourId;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return number;
	}
	
	
	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "number";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return number;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return number;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("number", "asc");
		return map;

	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
