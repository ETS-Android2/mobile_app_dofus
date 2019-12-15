package com.example.project.appclasses;

public class Objectives {

    int id;
    String title;
    String content;
    int user_id;


    public Objectives(String title, String content, int user_id) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }

    public Objectives(int id, String title, String content, int user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
