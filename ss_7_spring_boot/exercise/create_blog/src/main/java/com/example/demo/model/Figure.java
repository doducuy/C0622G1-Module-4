package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Figure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private String appearance;
    private String sect;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id", referencedColumnName = "id")
    private Account account;
    public Figure() {
    }

    public Figure(int id, String name, String gender, String appearance, String sect) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.appearance = appearance;
        this.sect = sect;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
