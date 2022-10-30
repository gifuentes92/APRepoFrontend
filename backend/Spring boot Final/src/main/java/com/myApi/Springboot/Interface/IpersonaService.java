
package com.myApi.Springboot.Interface;

import com.myApi.Springboot.Model.Persona;
import java.util.List;


public interface IpersonaService {
    
    //traer lista de personas
    public List<Persona> getPersona();
    
    //Guardar objeto de tipo Persona
public void savePersona(Persona persona);

//Eliminar un objeto buscando por ID
public void deletePersona(Long id);

//Buscar persona por ID
public Persona findPersona(Long id);
 

}
