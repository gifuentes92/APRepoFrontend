
package com.myApi.miportfolio.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Educacion {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    @Basic
    String titulo;
   String institucion;
   String curso;
   Long inicio;
   Long fin;

    public Educacion(long id, String titulo, String institucion, String curso, Long inicio, Long fin) {
        this.id = id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.curso = curso;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Educacion() {
 
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
