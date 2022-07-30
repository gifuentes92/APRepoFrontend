package com.myApi.Springboot.Service;

import com.myApi.Springboot.Model.Persona;
import com.myApi.Springboot.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepo;

    public void CrearPersona(Persona persona) {

        personaRepo.save(persona);

    }

    public void borrarPersona(Long id) {
        personaRepo.deleteById(id);
    }
    
    public List<Persona> listarPersonas(){
    return personaRepo.findAll();
    }
    
    public Persona buscarPersonaPorId(Long id)
    {
        return personaRepo.findById(id).orElse(null);
    }
    
    public void modificarPersona (Persona persona)
    {
    personaRepo.save(persona);
    }
}
