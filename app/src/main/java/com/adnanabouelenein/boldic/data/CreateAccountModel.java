package com.adnanabouelenein.boldic.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateAccountModel {

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("phone")
    @Expose
    private String phone;


    public CreateAccountModel(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "CreateAccount{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

