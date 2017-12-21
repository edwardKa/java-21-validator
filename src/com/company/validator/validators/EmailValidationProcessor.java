package com.company.validator.validators;

import com.company.validator.BaseValidator;

public class EmailValidationProcessor implements BaseValidator {

    private String value;

    public EmailValidationProcessor(String value) {
        this.value = value;
    }

    @Override
    public void validate() {
        if (value == null || value.trim().length() == 0) {
            return;
        }

        if (value.contains("@") && value.substring(value.indexOf('@'), value.length()).contains(".")) {
            return;
        }

        throw new RuntimeException("Email validation failed");
    }
}
