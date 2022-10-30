
package com.myApi.miportfolio.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity

@Getter @Setter
public class Persona {
      @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  long id;
    @Basic
   String nombre;
    String urlfoto;
    String puesto;
    String acercade;

    public Persona(long id, String nombre, String urlfoto, String puesto, String acercade) {
        this.id = id;
        this.nombre = nombre;
        this.urlfoto = urlfoto;
        this.puesto = puesto;
        this.acercade = acercade;
    }

    public Persona() {
    }
}


    
    

