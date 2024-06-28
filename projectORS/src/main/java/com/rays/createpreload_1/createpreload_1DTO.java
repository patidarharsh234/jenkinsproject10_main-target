package com.rays.createpreload_1;


import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;



@Entity
@Table(name = "ST_CREATEPRELOAD_1")
public class createpreload_1DTO extends BaseDTO {
	
	  
	@Column(name="PRIORITY")                   //2
	private String priority;





	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return priority;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("priority", "asc");
		return map;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
