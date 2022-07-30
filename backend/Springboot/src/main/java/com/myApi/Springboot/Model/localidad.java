
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
public class localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idLocalidad;
    @Basic
    String Nombre;

    public localidad(long idLocalidad, String Nombre) {
        this.idLocalidad = idLocalidad;
        this.Nombre = Nombre;
    }

    public localidad() {
    }
    
    
}
