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
public class dtoPersona {
    @NotBlank
    String nombre;
    @NotBlank
    String urlfoto;
    @NotBlank
    String acercade;
    @NotBlank
    String puesto;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String urlfoto, String acercade, String puesto) {
        this.nombre = nombre;
        this.urlfoto = urlfoto;
        this.acercade = acercade;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public String getAcercade() {
        return acercade;
    }

    public void setAcercade(String acercade) {
        this.acercade = acercade;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
}
