package com.rays.createusecase_2;


import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.rays.common.BaseDTO;




@Entity
@Table(name = "ST_CREATEUSECASE_2")
public class createusecase_2DTO extends BaseDTO {
	
@Column(name="UNIQUEID",length = 500)  //1
private String uniqueId;
  
@Column(name="ADDRES")                   //2
private String addres;



@Column(name="DATEFILED")               //3
private Date dateFiled;


@Column(name="LONGVALUE",length = 500) //4
private Long longValue;

@Column(name="mobileNo")               //5
private Long mobileNo;


@Column(name="productID")               //6
private Long productId; //Daynemic aati he.

@Column(name="product",length = 500)     //7
private String product; //daynemic productId ki help se preload se get krte he.








public String getUniqueId() {
	return uniqueId;
}

public void setUniqueId(String uniqueId) {
	this.uniqueId = uniqueId;
}

public String getAddres() {
	return addres;
}

public void setAddres(String addres) {
	this.addres = addres;
}

public Date getDateFiled() {
	return dateFiled;
}

public void setDateFiled(Date dateFiled) {
	this.dateFiled = dateFiled;
}



public Long getLongValue() {
	return longValue;
}

public void setLongValue(Long longValue) {
	this.longValue = longValue;
}

public Long getMobileNo() {
	return mobileNo;
}

public void setMobileNo(Long mobileNo) {
	this.mobileNo = mobileNo;
}





public Long getProductId() {
	return productId;
}

public void setProductId(Long productId) {
	this.productId = productId;
}

public String getProduct() {
	return product;
}

public void setProduct(String product) {
	this.product = product;
}





	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "uniqueId";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return uniqueId ;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "uniqueId is ";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("uniqueId", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
