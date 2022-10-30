package com.myApi.Springboot.Model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Basic
    String nombre;
    String apellido;
    String urlfoto;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date fecha_nacimiento;
    String acerca_de;
    String email;
    String puesto;
   
 
    

    public Persona(Long id, String nombre, String apellido, String urlfoto, Date fecha_nacimiento, String acerca_de, String email, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.urlfoto = urlfoto;
        this.fecha_nacimiento = fecha_nacimiento;
        this.acerca_de = acerca_de;
        this.email = email;
        this.puesto = puesto;
        
    }

    public Persona() {
    }

}
