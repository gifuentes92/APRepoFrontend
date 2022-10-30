
package com.myApi.Springboot.Service;

import com.myApi.Springboot.Model.idiomas;
import com.myApi.Springboot.Repository.idiomasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class idiomasService {
    
     @Autowired
    idiomasRepository idiomasRepo;
     
     public void CrearIdiomas(idiomas idiomas) {

        idiomasRepo.save(idiomas);

    }

    public void borrarIdiomas(Long id) {
        idiomasRepo.deleteById(id);
    }
    
    public List<idiomas> listarEducacion(){
    return idiomasRepo.findAll();
    }
    
    public idiomas buscarIdiomasPorId(Long id)
    {
        return idiomasRepo.findById(id).orElse(null);
    }
    
}
