package com.myApi.Springboot.Services;

import com.myApi.Springboot.Interface.IpersonaService;
import com.myApi.Springboot.Model.Persona;
import com.myApi.Springboot.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IpersonaService {

    @Autowired
    PersonaRepository personaRepo;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = personaRepo.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepo.save(persona);

    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

 
@Override
    public Persona findPersona(Long id) {
        Persona persona= personaRepo.findById(id).orElse(null);
        return persona;
    }
}
    
 
