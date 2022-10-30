/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.Springboot.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    String titulo;
    @NotBlank
     String institucion;
    @NotBlank
     String curso;
    @NotBlank
     Long inicio;
    @NotBlank
     Long fin;

    public dtoEducacion() {
    }

    public dtoEducacion(String titulo, String institucion, String curso, Long inicio, Long fin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.curso = curso;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Long getInicio() {
        return inicio;
    }

    public void setInicio(Long inicio) {
        this.inicio = inicio;
    }

    public Long getFin() {
        return fin;
    }

    public void setFin(Long fin) {
        this.fin = fin;
    }


    
    
    
}
