package com.rays.validateanotation;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public void initialize(ValidDate constraintAnnotation) {
        // Initialization code if needed
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext context) {
        if (date == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        sdf.setLenient(false);
        try {
            // This will throw ParseException if the date is invalid
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
        	System.out.println("date formate is invalidate......!!!!!!!");
            return false;
        }
    }
}