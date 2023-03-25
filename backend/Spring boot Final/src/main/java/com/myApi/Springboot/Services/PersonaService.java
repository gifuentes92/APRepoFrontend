package com.myApi.Springboot.Services;

import com.myApi.Springboot.Interface.IpersonaService;
import com.myApi.Springboot.Model.Persona;
import com.myApi.Springboot.Repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
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
    
      public Optional<Persona> mostrarPorNombre(String nombre) {
          return personaRepo.findByNombre(nombre);
      }
      
      public Optional<Persona> mostrarPorUrlfoto(String urlfoto) {
          return personaRepo.findByUrlfoto(urlfoto);
      }
      
      public Optional<Persona> mostrarPorAcercade(String acercade) {
          return personaRepo.findByAcercade(acercade);
      }
      
       public Optional<Persona> mostrarPorPuesto(String puesto) {
          return personaRepo.findByPuesto(puesto);
      }
    
   
     public Optional<Persona> getOne(Long id) {
          return personaRepo.findById(id);
      }
     
         public boolean existsById(Long Id) {
          return personaRepo.existsById(Id);
      }
    
            public boolean existePorNombre(String nombre) {
          return personaRepo.existsByNombre(nombre);
      }
      
      public boolean existePorUrlfoto(String urlfoto) {
          return personaRepo.existsByUrlfoto(urlfoto);
      }

public boolean existePorPuesto(String puesto) {
          return personaRepo.existsByPuesto(puesto);
      }
    
}
    
 
