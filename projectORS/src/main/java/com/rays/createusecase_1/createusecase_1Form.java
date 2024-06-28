package com.rays.createusecase_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.validateanotation.ValidDate;

public class createusecase_1Form extends BaseForm {

	@NotBlank(message = "please enter name")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "The name must contain only alphabetic characters.")
	private String names;

	@NotBlank(message = "please enter address ")
	private String address;

	//Long and Intiger value
	@NotBlank(message = "please enter salary")
	@Pattern(regexp = "^\\d*$", message = "salary must be a number")
	private String salary;

	@NotBlank(message = "please enter doubleValue")
	@Pattern(regexp = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?$", message = "doubleValue must be a number")
	private String doubleValue;
	
	
	@NotBlank(message = "please enter clientDate")
	@ValidDate(message = "select valid clientDate ")
	private String clientDate;

	@NotBlank(message = "please enter phoneNo")
	@Pattern(regexp = "^[1-9][0-9]{9}$", message = "The mobile number should contain only 10 digits.")
	private String phoneNo;

	@NotBlank(message = "please enter name")
	@Email
	private String emailId;
	
	

	@NotBlank(message = "please enter priorityId ")
	@Pattern(regexp = "^\\d*$", message = "priorityId must be a number")
	private String priorityId;

	private String priority;
	
	
	
	
	
	public String getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(String doubleValue) {
		this.doubleValue = doubleValue;
	}

	public String getphoneNo() {
		return phoneNo;
	}

	public void setphoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getclientDate() {
		return clientDate;
	}

	public void setclientDate(String clientDate) {
		this.clientDate = clientDate;
	}

	public String getsalary() {
		return salary;
	}

	public void setsalary(String salary) {
		this.salary = salary;
	}

	public String getpriorityId() {
		return priorityId;
	}

	public void setpriorityId(String priorityId) {
		this.priorityId = priorityId;
	}



	public String getpriority() {
		return priority;
	}

	public void setpriority(String priority) {
		this.priority = priority;
	}

	@Override
	public BaseDTO getDto() {

		createusecase_1DTO dto = initDTO(new createusecase_1DTO());
		dto.setNames(names);
		dto.setAddress(address);
		;

		try {
			if (clientDate != null && !clientDate.isEmpty()) {
				dto.setclientDate(new SimpleDateFormat("yyyy-MM-dd").parse(clientDate));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (salary != null && !salary.isEmpty()) {
			dto.setSalary(Long.parseLong(salary));
		}

		if (doubleValue != null && !doubleValue.isEmpty()) {
			dto.setDoubleValue(Double.parseDouble(doubleValue));
		}
		
			if(phoneNo !=null && !phoneNo.isEmpty()) {
				dto.setPhoneNo(Long.parseLong(phoneNo));
			}

		if (priorityId != null && !priorityId.isEmpty()) {
			dto.setPriorityId(Long.parseLong(priorityId));
		}
		dto.setPriority(priority);
		
		dto.setEmailId(emailId);

		return dto;
	}

}
