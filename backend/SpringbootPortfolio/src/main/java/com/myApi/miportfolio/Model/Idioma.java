
package com.myApi.miportfolio.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Idioma {
         @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    @Basic
    String lenguaje;
    String nivel;

    public Idioma(long id, String lenguaje, String nivel) {
        this.id = id;
        this.lenguaje = lenguaje;
        this.nivel = nivel;
    }

    public Idioma() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
