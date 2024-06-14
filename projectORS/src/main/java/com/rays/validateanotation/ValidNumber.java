package com.rays.validateanotation;
import javax.validation.Constraint;

import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNumber {
    String message() default "Invalid number format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}