package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String company;
    private String origin;

    public Product() {
    }

    public Product(int id, String name, String company, String origin) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
