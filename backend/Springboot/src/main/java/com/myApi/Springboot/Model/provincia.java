
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
public class provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idProvincia;
    @Basic
    String Nombre;

    public provincia(long idProvincia, String Nombre) {
        this.idProvincia = idProvincia;
        this.Nombre = Nombre;
    }

    public provincia() {
    }
    
}
