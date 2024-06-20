package com.rays.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.validateanotation.ValidDate;

public class ClientForm extends BaseForm {

	@NotBlank(message = "please enter name")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "The name must contain only alphabetic characters.")
	private String name;

	@NotBlank(message = "please enter address ")
	private String address;

	@NotBlank(message = "please enter salary")
	@Pattern(regexp = "^\\d*$", message = "salary must be a number")
	private String salary;

	@NotBlank(message = "please enter dateOfPurches")
	@ValidDate(message = "select valid dateOfPurches ")
	private String dateOfPurches;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getdateOfPurches() {
		return dateOfPurches;
	}

	public void setdateOfPurches(String dateOfPurches) {
		this.dateOfPurches = dateOfPurches;
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

		ClientDTO dto = initDTO(new ClientDTO());
		dto.setName(name);
		dto.setAddress(address);
		;

		try {
			if (dateOfPurches != null && !dateOfPurches.isEmpty()) {
				dto.setdateOfPurches(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfPurches));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (salary != null && !salary.isEmpty()) {
			dto.setSalary(Long.parseLong(salary));
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
