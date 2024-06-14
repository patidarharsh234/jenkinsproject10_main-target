package com.rays.product;



import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "PRELOAD_TABLE_NAME")
public class ProductDTO extends BaseDTO {

	@Column(name = "DESCRIPTION", length = 100)
	private String description = null;

	@Column(name = "product", length = 500)
	private String product;


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getproduct() {
		return product;
	}

	public void setproduct(String product) {
		this.product = product;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "product";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "product is requerd";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("product", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
