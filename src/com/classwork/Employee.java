package com.classwork;

import com.classwork.annotations.validator.validators.Length;
import com.classwork.annotations.validator.validators.NotNull;
import com.classwork.annotations.PrintAnnotation;

public class Employee {
    @PrintAnnotation(printValue = "FIRST NAME")
    @NotNull
    @Length(minValue = 1, maxValue = 10)
    private String firstName;

    @PrintAnnotation(printValue = "LAST NAME")
    @NotNull
    @Length(minValue = 1, maxValue = 10)
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}