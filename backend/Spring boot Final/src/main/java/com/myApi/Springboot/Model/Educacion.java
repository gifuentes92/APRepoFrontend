
package com.myApi.Springboot.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion implements Serializable {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Basic
     String titulo;
     String institucion;
     String curso;
     Long inicio;
     Long fin;
   
     
     public Educacion() {
    }

    public Educacion(String titulo, String institucion, String curso, Long inicio, Long fin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.curso = curso;
        this.inicio = inicio;
        this.fin = fin;
    }
     
     

   

    
}