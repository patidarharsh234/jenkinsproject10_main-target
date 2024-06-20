package com.rays.wishlist;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.validateanotation.ValidDate;

public class WishListForm extends BaseForm {

	@NotBlank(message = "please enter names")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "The names must contain only alphabetic characters.")
	private String names;

	@NotBlank(message = "please enter description ")
	private String description;

	@NotBlank(message = "please enter amount")
	@Pattern(regexp = "^\\d*$", message = "amount must be a number")
	private String amount;

	@NotBlank(message = "please enter dateOfPurches")
	@ValidDate(message = "select valid dateOfPurches ")
	private String dateOfPurches;

	@NotBlank(message = "please enter phoneNo")
	@Pattern(regexp = "^[1-9][0-9]{9}$", message = "The mobile number should contain only 10 digits.")
	private String phoneNo;

	@NotBlank(message = "please enter names")
	@Email
	private String emailId;
	
	

	@NotBlank(message = "please enter itemsId ")
	@Pattern(regexp = "^\\d*$", message = "itemsId must be a number")
	private String itemsId;

	private String items;
	
	
	
	
	
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

	public String getdateOfPurches() {
		return dateOfPurches;
	}

	public void setdateOfPurches(String dateOfPurches) {
		this.dateOfPurches = dateOfPurches;
	}

	public String getamount() {
		return amount;
	}

	public void setamount(String amount) {
		this.amount = amount;
	}

	public String getitemsId() {
		return itemsId;
	}

	public void setitemsId(String itemsId) {
		this.itemsId = itemsId;
	}



	public String getitems() {
		return items;
	}

	public void setitems(String items) {
		this.items = items;
	}

	@Override
	public BaseDTO getDto() {

		WishListDTO dto = initDTO(new WishListDTO());
		dto.setnames(names);
		dto.setdescription(description);
		;

		try {
			if (dateOfPurches != null && !dateOfPurches.isEmpty()) {
				dto.setdateOfPurches(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfPurches));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (amount != null && !amount.isEmpty()) {
			dto.setamount(Long.parseLong(amount));
		}

			if(phoneNo !=null && !phoneNo.isEmpty()) {
				dto.setPhoneNo(Long.parseLong(phoneNo));
			}

		if (itemsId != null && !itemsId.isEmpty()) {
			dto.setitemsId(Long.parseLong(itemsId));
		}
		dto.setitems(items);
		
		dto.setEmailId(emailId);

		return dto;
	}

}
