
package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Model.Contacto;
import com.myApi.Springboot.Security.Controller.Mensaje;
import com.myApi.Springboot.Services.ContactoService;
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
@RequestMapping("/contacto")
@RestController
public class ContactoController {
@Autowired
ContactoService contactoServ;
  
@GetMapping("/mostrar")
@ResponseBody
public List<Contacto> mostrarContacto(){
    
    return contactoServ.mostrarContacto();
}

  @GetMapping("/detail/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable("id") Long id) {
        if (!contactoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Contacto contacto = contactoServ.getOne(id).get();

        return new ResponseEntity(contacto, HttpStatus.OK);
    }


@PostMapping("/crear")
public void crearContacto(@RequestBody Contacto contacto){
    contactoServ.crearContacto(contacto);
}

@PutMapping("/editar/{id}")
public Contacto editarContaco(@RequestBody Contacto contacto, @PathVariable Long id){
    
    Contacto con = contactoServ.encontrarContacto(id);
   
   con.setDiscord(con.getDiscord());
   con.setTelegram(con.getTelegram());
   con.setGithub(con.getGithub());

    contactoServ.crearContacto(con);
   return con;
}


@DeleteMapping("/borrar/{id}")
public void borrarContacto(@PathVariable Long id){
    contactoServ.borrarContacto(id);
}
}