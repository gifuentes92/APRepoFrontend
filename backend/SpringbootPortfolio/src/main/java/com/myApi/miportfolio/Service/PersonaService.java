package com.myApi.miportfolio.Service;

import com.myApi.miportfolio.Model.Persona;
import com.myApi.miportfolio.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepo;

    public void crearPersona(Persona persona) {
        personaRepo.save(persona);
    }

    public void borrarPersona(Long id) {
        personaRepo.deleteById(id);
    }

    public Persona encontrarPersona(Long id) {
        return personaRepo.findById(id).orElse(null);
    }

    public void editarPersona(Persona persona) {
        personaRepo.save(persona);
    }
}
