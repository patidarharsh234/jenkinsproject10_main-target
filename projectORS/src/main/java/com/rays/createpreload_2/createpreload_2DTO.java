package com.rays.createpreload_2;





import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_CREATEPRELOAD_2")
public class createpreload_2DTO extends BaseDTO {


	@Column(name = "assignTo", length = 500)
	private String assignTo;




	

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return assignTo;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "assignTo";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return assignTo;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "assignTo";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("assignTo", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
