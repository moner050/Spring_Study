package com.example.objectmapper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public User()
    {

    }


    // 생성자 오버로딩
    public User(String name, int age, String phoneNumber)
    {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 작성한 클래스가 objectMapper 에서 작동될때는 get 을 빼줘야 한다.
    public User defaultUser()
    {
        return new User("default", 0, "010-0000-0000");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
