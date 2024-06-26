package com.rays.Product;


import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;



@Entity
@Table(name = "ST_productDTO")
public class ProductDTO extends BaseDTO {
	
	  
	@Column(name = "product", length = 500) // 1
	private String product;







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
		return "product";
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
