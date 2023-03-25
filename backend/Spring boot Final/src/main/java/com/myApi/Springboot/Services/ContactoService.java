
package com.myApi.Springboot.Services;

import com.myApi.Springboot.Model.Contacto;
import com.myApi.Springboot.Repository.ContactoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService {
     @Autowired
    ContactoRepository contactoRepo;

public void crearContacto(Contacto contacto)
    {
        contactoRepo.save(contacto);
    }
    
    public void borrarContacto(Long id){
       contactoRepo.deleteById(id);
    }
    
    public List<Contacto> mostrarContacto(){
      return  contactoRepo.findAll();
    }

    public Contacto encontrarContacto(Long id){
        Contacto contacto = contactoRepo.findById(id).orElse(null);
        return contacto;
    }

        public Optional<Contacto> getOne(Long id) {
          return contactoRepo.findById(id);
      }
     
         public boolean existsById(Long Id) {
          return contactoRepo.existsById(Id);
      }
    
}
