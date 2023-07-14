package com.example.TreeDictionary.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "NewsTree")
public class NewsTree {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", length = 2000)
    private String title;

    @Column(name = "desc", length = 8000)
    private String desc;
    
    @Column(name = "img", length = 8000)
    private String img;
    
    @Column(name = "path", length = 2000)
    private String path;

    public NewsTree() {
    }

    public NewsTree(long id, String title, String desc, String img, String path) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
}
