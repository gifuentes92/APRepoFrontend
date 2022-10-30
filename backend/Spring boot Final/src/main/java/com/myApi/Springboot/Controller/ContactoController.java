
package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Model.Contacto;
import com.myApi.Springboot.Services.ContactoService;
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
public class ContactoController {
@Autowired
ContactoService contactoServ;
  
@GetMapping("/contacto/mostrar")
@ResponseBody
public List<Contacto> mostrarContacto(){
    
    return contactoServ.mostrarContacto();
}

@PostMapping("/contacto/crear")
public void crearContacto(@RequestBody Contacto contacto){
    contactoServ.crearContacto(contacto);
}

@PutMapping("l/contacto/{id}")
public Contacto editarContaco(@RequestBody Contacto contacto, @PathVariable Long id){
    
    Contacto con = contactoServ.encontrarContacto(id);
   
   con.setDiscord(con.getDiscord());
   con.setTelegram(con.getTelegram());
   con.setGithub(con.getGithub());

    contactoServ.crearContacto(con);
   return con;
}


@DeleteMapping("/contacto/{id}")
public void borrarContacto(@PathVariable Long id){
    contactoServ.borrarContacto(id);
}
}