
package com.myApi.Springboot.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


 @Entity
public class Extra{
    
       @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    @Basic
    String skill;
    String programa;

    public Extra(Long id, String skill, String programa) {
        this.id = id;
        this.skill = skill;
        this.programa = programa;
    }

    public Extra() {
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

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

  
    
}   

