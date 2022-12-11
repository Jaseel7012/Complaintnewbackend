package com.example.complaints1Backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user1")
public class UserModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private  String email;
    private  String pno;
    private String password;

    public UserModel() {
    }

    public UserModel(int id, String name, String email, String pno, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pno = pno;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
