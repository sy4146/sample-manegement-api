package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "administrators")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "mail_address")
    private String mailAddress;

    private String password;

    public Administrator() {
    }

    public Administrator(String name, String mailAddress, String password) {
        this.name = name;
        this.mailAddress = mailAddress;
        this.password = password;
    }

    // getter/setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
