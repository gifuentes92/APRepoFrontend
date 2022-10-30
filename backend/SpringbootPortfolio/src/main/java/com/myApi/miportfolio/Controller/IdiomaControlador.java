
package com.myApi.miportfolio.Controller;

import com.myApi.miportfolio.Model.Idioma;
import com.myApi.miportfolio.Service.IdiomaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
///@CrossOrigin(origins ={"https://argentinaprograma-frontend.web.app"})
public class IdiomaControlador {
    
@Autowired
IdiomaServicio idiomaServ;
  
@GetMapping("/idioma/mostrar")
@ResponseBody
public List<Idioma> mostrarIdioma(){
    
    return idiomaServ.mostrarIdioma();
}

@PostMapping("/Idioma/crear")
public void crearIdioma(@RequestBody Idioma idioma){
    idiomaServ.crearIdioma(idioma);
}

@PutMapping("/idioma/editar/{id}")
public Idioma editarIdioma(@RequestBody Idioma idioma, @PathVariable Long id){
    
    Idioma idi = idiomaServ.encontrarIdioma(id);
   
   idi.setLenguaje(idioma.getLenguaje());
   idi.setNivel(idioma.getNivel());
   
   
   
   idiomaServ.crearIdioma(idi);
   return idi;
}


@DeleteMapping("/idioma/{id}")
public void borrarIdioma(@PathVariable Long id){
    idiomaServ.borrarIdioma(id);
}
}