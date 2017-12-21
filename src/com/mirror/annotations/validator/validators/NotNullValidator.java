package com.mirror.annotations.validator.validators;

public class NotNullValidator {

    public static void validate(Object o) {
        if (o == null) {
            throw new RuntimeException("Field is null");
        }
    }
}
