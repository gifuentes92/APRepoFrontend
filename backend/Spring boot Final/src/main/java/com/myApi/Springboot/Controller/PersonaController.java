package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Dto.dtoPersona;
import com.myApi.Springboot.Model.Persona;
import com.myApi.Springboot.Security.Controller.Mensaje;
import com.myApi.Springboot.Services.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/traer")
    @ResponseBody
    public List<Persona> getPersona() {
        return personaService.getPersona();
    }
    
       @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();

        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
        return "la persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return "la persona fue eliminada correctamente";
    }

  
   
    
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoPersona dtopersona) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }

        if (personaService.existePorNombre(dtopersona.getNombre()) && personaService.mostrarPorNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existePorUrlfoto(dtopersona.getUrlfoto()) && personaService.mostrarPorUrlfoto(dtopersona.getUrlfoto()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esta imagen ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existePorPuesto(dtopersona.getAcercade()) && personaService.mostrarPorAcercade(dtopersona.getPuesto()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esta descripción ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();

        persona.setNombre(dtopersona.getNombre());
        persona.setUrlfoto(dtopersona.getUrlfoto());
        persona.setAcercade(dtopersona.getAcercade());
        persona.setPuesto(dtopersona.getPuesto());
        

         personaService.savePersona(persona);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Persona buscarPersonaPorId(@PathVariable Long id) {
        return personaService.findPersona(id);

    }
@GetMapping("/traer/perfil")
public Persona buscarPersona(){
    return personaService.findPersona((long)1);
}
}
