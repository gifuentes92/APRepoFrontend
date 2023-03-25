
package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Model.Idioma;
import com.myApi.Springboot.Security.Controller.Mensaje;
import com.myApi.Springboot.Services.IdiomaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/idioma")
@RestController
public class IdiomaController {
   
    @Autowired
IdiomaService idiomaServ;
  
@GetMapping("/mostrar")
@ResponseBody
public List<Idioma> mostrarIdioma(){
    
    return idiomaServ.mostrarIdioma();
}

    @GetMapping("/detail/{id}")
    public ResponseEntity<Idioma> getById(@PathVariable("id") Long id) {
        if (!idiomaServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Idioma idioma = idiomaServ.getOne(id).get();

        return new ResponseEntity(idioma, HttpStatus.OK);
    }

@PostMapping("/crear")
public void crearIdioma(@RequestBody Idioma idioma){
    idiomaServ.crearIdioma(idioma);
}

@PutMapping("/editar/{id}")
public Idioma editarIdioma(@RequestBody Idioma idioma, @PathVariable Long id){
    
    Idioma idi = idiomaServ.encontrarIdioma(id);
   
   idi.setLenguaje(idioma.getLenguaje());
   idi.setNivel(idioma.getNivel());
   
   
   
   idiomaServ.crearIdioma(idi);
   return idi;
}


@DeleteMapping("/borrar/{id}")
public void borrarIdioma(@PathVariable Long id){
    idiomaServ.borrarIdioma(id);
}
}

