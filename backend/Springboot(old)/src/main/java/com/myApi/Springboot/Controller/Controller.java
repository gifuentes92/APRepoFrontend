package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Model.Persona;
import com.myApi.Springboot.Service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class Controller {

    @Autowired
    PersonaService personaService;

    /* @GetMapping("/persona/{nombre}")
    public String Saludar(@PathVariable String nombre) {
        return "hola mundo! soy " + nombre;
    }*/
    @GetMapping("/persona/saludar")
    public String Saludar(@RequestParam String nombre, @RequestParam String apellido) {
        return "hola mundo! soy " + nombre + " " + apellido;
    }

    @GetMapping("/personaslista")
    @ResponseBody
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }

    @PostMapping("/persona")
    public void crearPersona(@RequestBody Persona persona) {

        personaService.CrearPersona(persona);

    }

    @DeleteMapping("/persona/{id}")
    public void borrarPersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
    }

    @ResponseBody
    @GetMapping("/persona/{id}")
    public Persona buscarPersonaPorId(@PathVariable Long id) {
        return personaService.buscarPersonaPorId(id);
    }

    @PutMapping("/persona")
    public void editarPersona(@RequestBody Persona persona){
   personaService.editarPersona(persona);
    }
}