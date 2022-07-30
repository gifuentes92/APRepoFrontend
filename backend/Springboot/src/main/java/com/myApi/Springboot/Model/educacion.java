
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
public class educacion {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEducacion;
    @Basic
    String institucion;
    String titulo;
    String carrera;
    String nota_promedio;
    int inicio ;
    int  fin;
    
  /*  @ManyToOne(mappedBy= "Persona")
    private Persona Persona*/

 
    

    public educacion(long idEducacion, String institucion, String titulo, String carrera, String nota_promedio, int inicio, int fin) {
        this.idEducacion = idEducacion;
        this.institucion = institucion;
        this.titulo = titulo;
        this.carrera = carrera;
        this.nota_promedio = nota_promedio;
        this.inicio = inicio;
        this.fin = fin;
    }

    
    public educacion() {
    }
  
}
