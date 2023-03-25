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
public class dtoIdioma {
    @NotBlank 
    String lenguaje;
    @NotBlank
    String nivel;

    public dtoIdioma() {
    }

    public dtoIdioma(String lenguaje, String nivel) {
        this.lenguaje = lenguaje;
        this.nivel = nivel;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
