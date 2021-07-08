package com.orange5.proposta.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Base64Validator implements ConstraintValidator<Base64, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            byte[] isBase64 = java.util.Base64.getDecoder().decode(value.getBytes());
            new String(isBase64);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
