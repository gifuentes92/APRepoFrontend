
package com.myApi.Springboot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona {
      @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
    
      @NotNull
     @Size(min=1, max=50, message="no cumple con la longitud")
    private String nombre;
     
     @Size(min=1, max=50, message="no cumple con la longitud")
   private String urlfoto;
      
     @Size(min=1, max=50, message="no cumple con la longitud")
   private String acercade;
      
     @Size(min=1, max=50, message="no cumple con la longitud")
    private String puesto;

    public Persona() {
    }

    public Persona(long id, String nombre, String urlfoto, String acercade, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.urlfoto = urlfoto;
        this.acercade = acercade;
        this.puesto = puesto;
    }


  
    

  
}
