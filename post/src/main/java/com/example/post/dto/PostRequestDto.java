package com.example.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {

    private String account;
    private String email;
    private String address;
    private String password;

    // 카멜케이스로 변수선언을 했는데 스네이크케이스로 값이 들어올때 테스트
    // ObjectMapper 라는 라이브러리로 이름을 지정해줘서 매칭해줘야한다.
    // 또는 어노테이션을 사용해 매칭해 줄 수 있다.
    @JsonProperty("phone_number")
    private String phoneNumber; // phone_number

    // 스네이크 케이스도 아니고 카멜케이스도 아닐때는
    // 특정 이름으로 매칭을 시켜줘서 파싱해줘야 한다.
    @JsonProperty("OTP")
    private String OTP;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
