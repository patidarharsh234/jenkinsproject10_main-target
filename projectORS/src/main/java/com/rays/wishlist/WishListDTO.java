package com.rays.wishlist;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_WISHLIST")
public class WishListDTO extends BaseDTO {

	@Column(name = "NAME", length = 500) // 1
	private String names;
	
	
	@Column(name = "description", length = 500) // 1
	private String description;
	
	
	@Column(name = "amount") // 1
	private Long amount;

	
	@Column(name = "DATE_OF_PURCHES") // 1
	private Date dateOfPurches;
	
	
	@Column(name = "PHONE_NO") // 1
	private Long phoneNo;
	
	@Column(name = "EMAIL_ID" ,length = 500) // 1
	private String emailId;

	
	//role
	
	@Column(name = "ITEMS", length = 500) // 1
	private String items;
	
	@Column(name = "ITEMS_ID") // 1
	private Long itemsId;




	

	

	
	
	public String getnames() {
		return names;
	}

	public void setnames(String names) {
		this.names = names;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public Long getamount() {
		return amount;
	}

	public void setamount(Long amount) {
		this.amount = amount;
	}

	public Date getdateOfPurches() {
		return dateOfPurches;
	}

	public void setdateOfPurches(Date dateOfPurches) {
		this.dateOfPurches = dateOfPurches;
	}


	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getitems() {
		return items;
	}

	public void setitems(String items) {
		this.items = items;
	}

	public Long getitemsId() {
		return itemsId;
	}

	public void setitemsId(Long itemsId) {
		this.itemsId = itemsId;
	}
	
	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return names;
	}
	
	
	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("names", "asc");
		return map;

	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
