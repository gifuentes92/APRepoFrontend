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
public class extra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idextra;
    @Basic
    String Habilidad;
    String Programa;

    public extra(long idextra, String Habilidad, String Programa) {
        this.idextra = idextra;
        this.Habilidad = Habilidad;
        this.Programa = Programa;
    }

    public extra() {
    }
    
    
}
