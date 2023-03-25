
package com.myApi.Springboot.Services;

import com.myApi.Springboot.Model.Extra;
import com.myApi.Springboot.Repository.ExtraRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtraService {
    
      @Autowired
    ExtraRepository extraRepo;

    public void crearExtra(Extra extra) {
        extraRepo.save(extra);
    }

    public void borrarExtra(Long id) {
        extraRepo.deleteById(id);
    }

       public Optional<Extra> getOne(Long id) {
          return extraRepo.findById(id);
      }
    
    public List<Extra> mostrarExtra() {
        return extraRepo.findAll();
    }

    public Extra encontrarExtra(Long id) {
        Extra extra = extraRepo.findById(id).orElse(null);
        return extra;
    
}
    
      public boolean existsById(Long Id) {
          return extraRepo.existsById(Id);
      }

}
