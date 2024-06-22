package com.rays.vehicle;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.validateanotation.ValidDate;

public class VehicleForm extends BaseForm {

	@NotBlank(message = "please enter number")
	// @Pattern(regexp = "^[a-zA-Z ]+$", message = "The names must contain only
	// alphabetic characters.")
	private String number;

	@NotBlank(message = "please enter description ")
	@Pattern(regexp = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)$", message = "insuranceAmount is contean only decimal numbers")
	private String insuranceAmount;

	@NotBlank(message = "please enter purchaseDate")
	@ValidDate(message = "select valid purchaseDate ")
	private String purchaseDate;

	// Role

	@NotBlank(message = "please enter colourId ")
	@Pattern(regexp = "^\\d*$", message = "colourId must be a number")
	private String colourId;

	private String Colour;

	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(String insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getColourId() {
		return colourId;
	}

	public void setColourId(String colourId) {
		this.colourId = colourId;
	}

	public String getColour() {
		return Colour;
	}

	public void setColour(String colour) {
		Colour = colour;
	}

	@Override
	public BaseDTO getDto() {

		vehicleDTO dto = initDTO(new vehicleDTO());
	dto.setNumber(number);

		try {
			if (purchaseDate != null && !purchaseDate.isEmpty()) {
				dto.setPurchaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(purchaseDate));
			
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (insuranceAmount != null && !insuranceAmount.isEmpty()) {
			dto.setInsuranceAmount(Double.parseDouble(insuranceAmount));
		}

	

		if (colourId != null && !colourId.isEmpty()) {
			dto.setColourId(Long.parseLong(colourId));
		}
		dto.setColour(Colour);

		return dto;
	}

}
