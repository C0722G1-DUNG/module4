package com.codegym.validate.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    @NotBlank @Size( min = 0,max = 45,message = "firstName không đúng định dạng")
    private String firstName;
    @NotBlank @Size( min = 0,max = 45,message = "firstName không đúng định dạng")
    private String lastName;
    @Pattern(regexp ="[0-9]{10}")
    private String phoneNumber;
@Max(value = 18 , message = "tuổi lớn hơn 18")
private int age;
@Pattern(regexp = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(.[A-Za-z0-9]+)")
    private String email;

    public User() {
    }

    public User( String firstName, String lastName, String phoneNumber, int age, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
