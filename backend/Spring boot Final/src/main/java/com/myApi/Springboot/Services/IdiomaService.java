package com.myApi.Springboot.Services;

import com.myApi.Springboot.Model.Idioma;
import com.myApi.Springboot.Repository.IdiomaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomaService {

    @Autowired
    IdiomaRepository idiomaRepo;

    public void crearIdioma(Idioma idioma) {
        idiomaRepo.save(idioma);
    }

    public void borrarIdioma(Long id) {
        idiomaRepo.deleteById(id);
    }

     public Optional<Idioma> getOne(Long id) {
          return idiomaRepo.findById(id);
      }
    
    public List<Idioma> mostrarIdioma() {
        return idiomaRepo.findAll();
    }

    public Idioma encontrarIdioma(Long id) {
        Idioma idioma = idiomaRepo.findById(id).orElse(null);
        return idioma;

    }
    
      public boolean existsById(Long Id) {
          return idiomaRepo.existsById(Id);
      }

}
