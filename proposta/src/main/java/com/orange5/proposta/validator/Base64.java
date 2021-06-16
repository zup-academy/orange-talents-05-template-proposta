package com.orange5.proposta.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Constraint(validatedBy = { Base64Validator.class })
@Target({ FIELD })
@Retention(RUNTIME)
public @interface Base64 {

    String message() default "{javax.validation.constraints.Base64.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
