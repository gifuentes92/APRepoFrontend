
package com.myApi.miportfolio.Service;

import com.myApi.miportfolio.Model.Contacto;
import com.myApi.miportfolio.Repository.ContactoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoServicio {
    @Autowired
    ContactoRepositorio contactoRepo;

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

    
}
