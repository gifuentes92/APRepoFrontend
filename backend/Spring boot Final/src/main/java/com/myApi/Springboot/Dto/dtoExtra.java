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
public class dtoExtra {
    @NotBlank
    String skill;
    @NotBlank
    String programa;

    public dtoExtra() {
    }

    public dtoExtra(String skill, String programa) {
        this.skill = skill;
        this.programa = programa;
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
