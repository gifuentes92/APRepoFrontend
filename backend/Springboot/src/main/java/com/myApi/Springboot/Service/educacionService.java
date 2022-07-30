
package com.myApi.Springboot.Service;

import com.myApi.Springboot.Model.educacion;
import com.myApi.Springboot.Repository.educacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class educacionService {
    
     @Autowired
    educacionRepository educacionRepo;
     
     public void CrearEducacion(educacion educacion) {

        educacionRepo.save(educacion);

    }

    public void borrarEducacion(Long id) {
        educacionRepo.deleteById(id);
    }
    
    public List<educacion> listarEducacion(){
    return educacionRepo.findAll();
    }
    
    public educacion buscarEducacionPorId(Long id)
    {
        return educacionRepo.findById(id).orElse(null);
    }
}
    

