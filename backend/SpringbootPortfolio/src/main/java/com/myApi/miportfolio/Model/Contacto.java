
package com.myApi.miportfolio.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contacto {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   Long id;
      @Basic
  String discord;
 String telegram;
  String github;

    public Contacto(long id, String discord, String telegram, String github) {
        this.id = id;
        this.discord = discord;
        this.telegram = telegram;
        this.github = github;
    }

    public Contacto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiscord() {
        return discord;
    }

    public void setDiscord(String discord) {
        this.discord = discord;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }


     
}
