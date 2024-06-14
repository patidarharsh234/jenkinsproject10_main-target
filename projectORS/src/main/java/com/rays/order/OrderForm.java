package com.rays.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.validateanotation.TrimmedPattern;
import com.rays.validateanotation.ValidDate;
import com.rays.validateanotation.ValidNumber;

public class OrderForm extends BaseForm {

	@NotBlank(message = "please enter uniqueId")
  // @Pattern(regexp = "^[a-zA-Z ]+$", message = "The name must contain only alphabetic characters.")
  //	@Email
	private String uniqueId;
	
	@NotBlank(message = "please enter Addres ")
	private String addres;

	@NotBlank(message ="please enter dateFiled")
	@ValidDate(message = "select valid dateFiled ")
	private String dateFiled;

	
	@NotBlank(message = "please enter longValue")
//	 @ValidNumber(message = "quantity muts be an numbersssss")
	@Pattern(regexp = "^\\d*$", message = "longValue must be a number")
	private String longValue;


	@NotBlank(message = "please enter mobileNo")
	@Pattern(regexp = "^[1-9][0-9]{9}$", message = "The mobile number should contain only 10 digits.")
	private String mobileNo; 
	


	
	
	@NotBlank(message = "please enter PRODUCTID ")
	@Pattern(regexp = "^\\d*$", message = "PRODUCTID must be a number")
	private String productId;

	private String product;
	
	
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
	
	
	
	
	public String getDateFiled() {
		return dateFiled;
	}

	public void setDateFiled(String dateFiled) {
		this.dateFiled = dateFiled;
	}

	
	
	public String getLongValue() {
		return longValue;
	}

	public void setLongValue(String longValue) {
		this.longValue = longValue;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}






	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public BaseDTO getDto() {

		OrderDTO dto = initDTO(new OrderDTO());
		dto.setUniqueId(uniqueId);
		dto.setAddres(addres);
		
		
		try {
			if (dateFiled != null && !dateFiled.isEmpty()) {
				dto.setDateFiled(new SimpleDateFormat("yyyy-MM-dd").parse(dateFiled));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		if (longValue != null && !longValue.isEmpty()) {
			dto.setLongValue(Long.parseLong(longValue));
		}
		
		if(mobileNo !=null && !mobileNo.isEmpty()) {
			dto.setMobileNo(Long.parseLong(mobileNo));
		}

		if (productId != null && !productId.isEmpty()) {
			dto.setProductId(Long.parseLong(productId));
		}
		
		
		dto.setProduct(product);

		
		
	
		return dto;
	}

}
