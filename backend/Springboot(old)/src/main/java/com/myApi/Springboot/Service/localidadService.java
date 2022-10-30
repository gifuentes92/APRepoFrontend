
package com.myApi.Springboot.Service;

import com.myApi.Springboot.Model.localidad;
import com.myApi.Springboot.Repository.localidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class localidadService {
    
    @Autowired
    localidadRepository localidadRepo;
    
    
     public List<localidad> listarLocalidad(){
    return localidadRepo.findAll();
    }
    
    public localidad buscarLocalidadPorId(Long id)
    {
        return localidadRepo.findById(id).orElse(null);
    }
    
}
