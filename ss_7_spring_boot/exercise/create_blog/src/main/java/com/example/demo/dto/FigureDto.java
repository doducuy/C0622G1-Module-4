package com.example.demo.dto;

public class FigureDto {
    private int id;
    private String name;
    private String gender;
    private String appearance;
    private String sect;

    public FigureDto() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getSect() {
        return sect;
    }

    public void setSect(String sect) {
        this.sect = sect;
    }
}
