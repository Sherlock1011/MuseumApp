package com.example.museumapp.bean;

public class New {
    private int icon;
    private String title;
    private String content;

    public New(int icon, String title, String content) {
        this.icon = icon;
        this.title = title;
        this.content = content;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
