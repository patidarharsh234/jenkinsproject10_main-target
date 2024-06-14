package com.rays.validateanotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNumberValidator implements ConstraintValidator<ValidNumber, String> {

    @Override
    public void initialize(ValidNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // Use @NotEmpty for null checks
        }
        try {
            Long.parseLong(value);
        } catch (NumberFormatException e) {
        	System.out.println("nuber formate exception...........!!!!!");
            return false;
        }
        return true;
    }
}