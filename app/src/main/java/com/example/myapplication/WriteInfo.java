package com.example.myapplication;
//activity_write에서 넘어가는 정보

import java.util.Date;

public class WriteInfo {
    private String content;
    private String date;

    public WriteInfo() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
