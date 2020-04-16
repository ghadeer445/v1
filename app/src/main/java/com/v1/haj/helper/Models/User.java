package com.v1.haj.helper.Models;

public class User {

    String fullname;
    String email;
    String mobile;
    String username;
    String password;
    String address;
    String type;
    String created_at;
    String updated_at;

    public User(String fullname, String email, String mobile, String username, String password, String address, String type, String created_at, String updated_at) {
        this.fullname = fullname;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.address = address;
        this.type = type;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
