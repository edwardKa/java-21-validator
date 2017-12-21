package com.classwork.annotations.validator.validators;

public class LengthValidator {
    public static void validate(String s,
                                int min,
                                int max) {
        if (s == null && min == 0) {
            return;
        }

        if (s == null) {
            throw new RuntimeException("Length is not valid. Value is null");
        }

        if (s.length() <= max &&
                s.length() >= min) {
            return;
        }

        throw new RuntimeException("Length is not valid. Length does not match/");
    }
}
