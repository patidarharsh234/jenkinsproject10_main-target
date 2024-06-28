package com.rays.createusecase_1;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_CREATEUSECASE_1")
public class createusecase_1DTO extends BaseDTO {

	@Column(name = "NAME", length = 500) // 1
	private String names;
	
	
	@Column(name = "ADDRESS", length = 500) // 1
	private String address;
	
	
	@Column(name = "SALARY") // 1
	private Long salary;

	
	@Column(name = "CLIENT_DATE") // 1
	private Date clientDate;
	
	
	@Column(name = "PHONE_NO") // 1
	private Long phoneNo;
	
	@Column(name = "EMAIL_ID" ,length = 500) // 1
	private String emailId;
	
	@Column(name = "doubleValue" ) // 1
	private double doubleValue;
	

	
	//role
	
	@Column(name = "priority", length = 500) // 1
	private String priority;
	
	@Column(name = "priority_Id") // 1
	private Long priorityId;




	

	
	
	public double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
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

	public Date getclientDate() {
		return clientDate;
	}

	public void setclientDate(Date clientDate) {
		this.clientDate = clientDate;
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
		return names;
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
		map.put("names", "asc");
		return map;

	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
