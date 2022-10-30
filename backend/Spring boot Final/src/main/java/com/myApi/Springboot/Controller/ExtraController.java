
package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Model.Extra;
import com.myApi.Springboot.Services.ExtraService;
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
public class ExtraController {
   
    @Autowired
    ExtraService extraServ;
  
@GetMapping("/extra/mostrar")
@ResponseBody
public List<Extra> mostrarIdioma(){
    
    return extraServ.mostrarExtra();
}

@PostMapping("/extra/crear")
public void crearExtra(@RequestBody Extra extra){
    extraServ.crearExtra(extra);
}

@PutMapping("/extra/editar/{id}")
public Extra editarExtra(@RequestBody Extra extra, @PathVariable Long id){
    
    Extra ext = extraServ.encontrarExtra(id);
   
   ext.setSkill(extra.getSkill());
   ext.setPrograma(extra.getPrograma());
   
   
   
   extraServ.crearExtra(ext);
   return ext;
}


@DeleteMapping("/extra/{id}")
public void borrarExtra(@PathVariable Long id){
    extraServ.borrarExtra(id);
}
}

