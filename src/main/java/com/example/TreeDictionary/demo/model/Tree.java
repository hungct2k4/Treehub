package com.example.TreeDictionary.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tree")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 400)
    private String name;

    @Column(name = "functions", length = 8000)
    private String functions;

    @Column(name = "path", length = 2000)
    private String path;

    @Column(name = "use", length = 8000)
    private String use;

    @Column(name = "sick", length = 8000)
    private String sick;

    public Tree(long id, String name, String functions, String path, String use, String sick) {
        this.id = id;
        this.name = name;
        this.functions = functions;
        this.path = path;
        this.use = use;
        this.sick = sick;
    }

    public String getSick() {
        return sick;
    }

    public void setSick(String sick) {
        this.sick = sick;
    }

    public Tree() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }
}
