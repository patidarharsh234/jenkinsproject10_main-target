package com.rays.client;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_CLIENT")
public class ClientDTO extends BaseDTO {

	@Column(name = "NAME", length = 500) // 1
	private String name;
	
	
	@Column(name = "ADDRESS", length = 500) // 1
	private String address;
	
	
	@Column(name = "SALARY") // 1
	private Long salary;

	
	@Column(name = "CLIENT_DATE") // 1
	private Date dateOfPurches;
	
	
	@Column(name = "PHONE_NO") // 1
	private Long phoneNo;
	
	@Column(name = "EMAIL_ID" ,length = 500) // 1
	private String emailId;

	
	//role
	
	@Column(name = "priority", length = 500) // 1
	private String priority;
	
	@Column(name = "priority_Id") // 1
	private Long priorityId;




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
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
		return name;
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
		map.put("name", "asc");
		return map;

	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
