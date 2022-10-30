
package com.myApi.miportfolio.Controller;

import com.myApi.miportfolio.Model.Persona;
import com.myApi.miportfolio.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin(origins ={"https://argentinaprograma-frontend.web.app"})
@RestController
public class PersonaController {
    
@Autowired
PersonaService personaService;
  
@ResponseBody
    @GetMapping("/persona/{id}")
public Persona encontrarPersona(@PathVariable Long id){
    return personaService.encontrarPersona(id);
}

@PostMapping("/persona/crear")
public void crearPersona(@RequestBody Persona persona){
    personaService.crearPersona(persona);
}

@PutMapping("/persona/editar/{id}")
public void editarExperiencia(@RequestBody Persona persona, @PathVariable Long id){
    
   personaService.editarPersona(persona);
}
@DeleteMapping("persona/{id}")
public void borrarPersona(@PathVariable Long id){
    personaService.borrarPersona(id);
}
}