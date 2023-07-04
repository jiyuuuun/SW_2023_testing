package com.example.myapplication;

public class UserAccount {
    public UserAccount() {}
    private String idToken;
    private String email;
    private String password;

    public void setIdToken(String idToken) {this.idToken = idToken;}
    public String getIdToken() {return idToken;}

    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}

    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return password;}
}
