package com.codegym.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String title;
    private String dayUpdate;
    private String content;

    public Blog() {
    }

    public Blog(int id, String author, String title, String dayUpdate, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.dayUpdate = dayUpdate;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDayUpdate() {
        return dayUpdate;
    }

    public void setDayUpdate(String dayUpdate) {
        this.dayUpdate = dayUpdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return String.format("Blog[id=%d, author='%s', title='%s',dayUpdate='%s',content='%s']", id, author, title,dayUpdate,content);
    }
}
