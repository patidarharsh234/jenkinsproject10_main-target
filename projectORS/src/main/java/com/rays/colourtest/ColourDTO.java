package com.rays.colourtest;


import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;



@Entity
@Table(name = "ST_COLOURDTO")
public class ColourDTO extends BaseDTO {
	
	  
	@Column(name="colour")                   //2
	private String colour;





	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("colour", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
