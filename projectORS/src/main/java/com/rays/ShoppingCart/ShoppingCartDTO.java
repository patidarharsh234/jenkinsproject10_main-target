package com.rays.ShoppingCart;

import java.util.Date;


import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;







/**
 * 
 */
@Entity
@Table(name = "ST_SHOPPINGCARTDTO")
public class ShoppingCartDTO extends BaseDTO{
	
	
	@Column(name = "NAME",length = 50) // 1
	private String name;
	
//	@Column(name = "DESCRIPTION",length = 50) // 1
//	private String description;
//	
//	@Column(name = "price") // 1
//	private double price;
	
	@Column(name = "QUANTITY") // 1
	private Long quantity;




	@Column(name = "DATES") // 1
	private Date dates;
	

	
	//role_1

	@Column(name = "product", length = 50) // 1
	private String product;


	@Column(name = "product_ID")
	private Long productId;

	





	public Long getquantity() {
		return quantity;
	}


	public void setquantity(Long quantity) {
		this.quantity = quantity;
	}




//
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public Date getdates() {
		return dates;
	}


	public void setdates(Date date) {
		this.dates = date;
	}


	
	
	public String getproduct() {
		return product;
	}


	public void setproduct(String product) {
		this.product = product;
	}


	public Long getproductId() {
		return productId;
	}


	public void setproductId(Long productId) {
		this.productId = productId;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "name";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "name";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("name", "asc");
		return map;

	}



	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
