package com.rays.ShoppingCart;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.validateanotation.ValidDate;

public class ShoppingCartForm extends BaseForm {

  @NotBlank(message = "please enter name")
 // @Pattern(regexp = "^[a-zA-Z ]+$", message = "The names must contain only alphabetic characters")
 @Size(max = 50, message = "The name must be at most 50 characters long")
private String name;

//	@NotBlank(message = "please enter description")
//	@Size(max = 100, message = "The description must be at most 100 characters long")
//	private String description;


//	@NotBlank(message = "please enter price")
//	@Size(max = 50, message = "The price must be at most 50 characters long")
//	@Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "price must be a number")
//	private String price;
  
  
	
	@NotBlank(message = "please enter quantity")
	@Size(max = 50, message = "The quantity must be at most 50 characters long")
	@Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "quantity must be a number")
	private String quantity;

	@NotBlank(message = "please enter dates")
	@ValidDate(message = "select valid dates ")
	private String dates;


	


	// Role--->

	@NotBlank(message = "please enter productId ")
	@Size(max = 50, message = "The productId must be at most 50 characters long")
	@Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "productId must be a number")
	private String productId;







	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
	
	
//	public String getPrice() {
//	return price;
//}
//
//public void setPrice(String price) {
//	this.price = price;
//}

	
	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getdates() {
		return dates;
	}

	public void setdates(String date) {
		this.dates = date;
	}



	public String getproductId() {
		return productId;
	}

	public void setproductId(String productId) {
		this.productId = productId;
	}

	@Override
	public BaseDTO getDto() {

		ShoppingCartDTO dto = initDTO(new ShoppingCartDTO());

		   
		    dto.setName(name);
		  //  dto.setDescription(description);
		    
		    
//			if (price != null && !price.isEmpty()) {
//				dto.setPrice(Double.parseDouble(price));
//			}
		    
		    
			if (quantity != null && !quantity.isEmpty()) {
				dto.setquantity(Long.parseLong(quantity));
			}
			
		    
		try {
			if (dates != null && !dates.isEmpty()) {
				dto.setdates(new SimpleDateFormat("yyyy-MM-dd").parse(dates));

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}


		if (productId != null && !productId.isEmpty()) {
			dto.setproductId(Long.parseLong(productId));
		}


		return dto;
	}

}
