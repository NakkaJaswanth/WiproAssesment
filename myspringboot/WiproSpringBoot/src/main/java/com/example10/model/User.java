package com.example10.model;

import jakarta.validation.constraints.*;

public class User {

    @NotBlank(message = "{user.name.notblank}")
    @Size(min = 2, max = 30, message = "{user.name.size}")
    private String name;

    @NotBlank(message = "{user.email.notblank}")
    @Email(message = "{user.email.invalid}")
    private String email;

    @Min(value = 18, message = "{user.age.min}")
    @Max(value = 120, message = "{user.age.max}")
    private Integer age;

    @NotNull(message = "{user.gender.notnull}")
    private String gender;

    public User() {
    }

    public User(String name, String email, Integer age, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}