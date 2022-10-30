
package com.myApi.Springboot.Service;

import com.myApi.Springboot.Model.extra;
import com.myApi.Springboot.Repository.extraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class extraService {
    
     @Autowired
    extraRepository extraRepo;
     
     public void CrearExtra(extra extra) {

        extraRepo.save(extra);

    }

    public void borrarExtra(Long id) {
        extraRepo.deleteById(id);
    }
    
    public List<extra> listarEducacion(){
    return extraRepo.findAll();
    }
    
    public extra buscarExtraPorId(Long id)
    {
        return extraRepo.findById(id).orElse(null);
    }
    
}
