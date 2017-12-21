package com.company;

import com.company.validator.Valid;
import com.company.validator.Validator;
import com.company.validator.validators.Email;
import com.company.validator.validators.Length;
import com.company.validator.validators.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {

//        User user = new User(
//	            "Peter",
//                "Dale",
//                "peter.dale@site.com",
//                30);
//        Validator.validate(user);
//
        Anomaly anomaly = new Anomaly("123@site.com");
        Validator.validate(anomaly);
    }
}

@Valid
class Anomaly {
    @Email
    private String email;

    public Anomaly(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


@Valid
class User {
    @NotNull
    @Length
    private String firstName;

    @NotNull
    @Length
    private String lastName;

    @NotNull
    @Email
    private String email;
    private Integer age;

    public User(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
