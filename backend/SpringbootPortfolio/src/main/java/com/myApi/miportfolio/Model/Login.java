package com.myApi.miportfolio.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Login {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Basic
    private String username;
    private String pass;

    public Login(long id, String username, String pass) {
        this.id = id;
        this.username = username;
        this.pass = pass;
    }

    public Login() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

 
  
    
    
}