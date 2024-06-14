package com.rays.validateanotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TrimmedPatternValidator implements ConstraintValidator<TrimmedPattern, String> {

    private String regex;

    @Override
    public void initialize(TrimmedPattern constraintAnnotation) {
        this.regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Consider null as valid, use @NotNull for non-null constraint
        }
        String trimmedValue = value.trim();
        return trimmedValue.matches(regex);
    }
}