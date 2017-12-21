package com.company.validator;

import com.company.validator.validators.Email;
import com.company.validator.validators.EmailValidationProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Validator {


    public static void validate(Object c) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (!c.getClass().isAnnotationPresent(Valid.class)) {
            return;
        }

        validateFields(c);
    }

    private static void validateFields(Object o) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                validateAnnotation(annotation, (String) field.get(o));
            }
        }
    }

    private static void validateAnnotation(Annotation annotation, String field) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (annotation.annotationType().equals(Email.class)) {
            EmailValidationProcessor emailValidationProcessor = EmailValidationProcessor
                    .class
                    .getDeclaredConstructor(String.class)
                    .newInstance(field);
            emailValidationProcessor.validate();
        }
    }

}
