/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.Springboot.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class conocimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idSkill;
    @Basic
    String skill;

    public conocimientos(long idSkill, String skill) {
        this.idSkill = idSkill;
        this.skill = skill;
    }

    
    
    public conocimientos() {
    }
    
    
}
