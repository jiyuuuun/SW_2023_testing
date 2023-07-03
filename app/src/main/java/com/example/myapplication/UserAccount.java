package com.example.myapplication;

public class UserAccount {
    public UserAccount() {}
    private String idToken;
    private String emailId;
    private String password;

    public void setIdToken(String idToken) {this.idToken = idToken;}
    public String getIdToken() {return idToken;}

    public void setEmailId(String emailId) {this.emailId = emailId;}
    public String getEmailId() {return emailId;}

    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return password;}
}
