/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.Springboot.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Woneja
 */
public class dtoSkill {
    @NotBlank
    String skill;

    public dtoSkill() {
    }

    
    public dtoSkill(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    
    
}
