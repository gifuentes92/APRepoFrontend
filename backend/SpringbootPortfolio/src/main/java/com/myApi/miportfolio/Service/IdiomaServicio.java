
package com.myApi.miportfolio.Service;

import com.myApi.miportfolio.Model.Idioma;
import com.myApi.miportfolio.Repository.IdiomaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomaServicio {
    @Autowired
    IdiomaRepositorio idiomaRepo;


 public void crearIdioma(Idioma idioma)
    {
        idiomaRepo.save(idioma);
    }
    
    public void borrarIdioma(Long id){
        idiomaRepo.deleteById(id);
    }
    
    public List<Idioma> mostrarIdioma(){
      return  idiomaRepo.findAll();
    }

    public Idioma encontrarIdioma(Long id){
        Idioma idioma = idiomaRepo.findById(id).orElse(null);
        return idioma;
    
}
}


