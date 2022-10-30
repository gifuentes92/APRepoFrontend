
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
public class idiomas {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long ididiomas;
    @Basic
    String lenguaje;
    String nivel;

    public idiomas(long idiomas, String lenguaje, String nivel) {
        this.ididiomas = idiomas;
        this.lenguaje = lenguaje;
        this.nivel = nivel;
    }


    
    
    public idiomas() {
    }
    
   
    
}
