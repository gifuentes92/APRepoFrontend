
package com.myApi.Springboot.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
     @Basic
     String skill;

    public Skill(Long id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    public Skill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
 
}
