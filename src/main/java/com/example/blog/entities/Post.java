package com.example.blog.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;

@Entity
@Table(name ="post")
public class Post{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name ="title")
    private String title;

    @Column(name ="content")
    private String content;

    @Column(name = "category")
    private String category;

    @Column(name = "image")
    private String image;

    @Column(name ="created_at")
    private Date created_at;

    public Post(){}

    public Post(int id, String title, String content, String category, String image, Date created_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.image = image;
        this.created_at = created_at;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    

    

}