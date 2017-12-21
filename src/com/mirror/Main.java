package com.mirror;

import com.mirror.annotations.PrintAnnotation;
import com.mirror.annotations.validator.validators.Length;
import com.mirror.annotations.validator.validators.LengthValidator;
import com.mirror.annotations.validator.validators.NotNull;
import com.mirror.annotations.validator.validators.NotNullValidator;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Employee employee = new Employee("John", "Smith");
        Field[] declaredFields = employee
                .getClass()
                .getDeclaredFields();


        for (Field field : declaredFields) {
            field.setAccessible(true);
            notNullProcessing(field, employee);
            lengthProcessing(field, employee);
            System.out.println(String.format("%s : %s",
                    getFieldName(field),
                    field.get(employee)));
        }

    }

    private static void notNullProcessing(Field field,
                                          Object employee) throws IllegalAccessException {
        if (field.getAnnotation(NotNull.class) != null) {
            field.setAccessible(true);
            Object o = field.get(employee);
            NotNullValidator.validate(o);
        }
    }

    private static void lengthProcessing(Field field,
                                         Object employee) throws IllegalAccessException {
        boolean annotationPresent = field
                .isAnnotationPresent(Length.class);

        if (annotationPresent) {
            Length length = field
                    .getAnnotation(Length.class);

//            field.setAccessible(true);
            Object o = field.get(employee);
            LengthValidator.validate((String)o,
                    length.minValue(),
                    length.maxValue());
        }
    }

    private static String getFieldName(Field field) {
        boolean annotationPresent = field
                .isAnnotationPresent(PrintAnnotation.class);
        if (annotationPresent) {
            PrintAnnotation annotation = field
                    .getAnnotation(PrintAnnotation.class);
            return annotation.printValue();
        }
        return field.getName();
    }

}


