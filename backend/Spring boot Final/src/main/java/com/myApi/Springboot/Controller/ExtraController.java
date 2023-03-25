
package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Model.Extra;
import com.myApi.Springboot.Security.Controller.Mensaje;
import com.myApi.Springboot.Services.ExtraService;
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

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/extra")
public class ExtraController {
   
    @Autowired
    ExtraService extraServ;
  
@GetMapping("/mostrar")
@ResponseBody
public List<Extra> mostrarIdioma(){
    
    return extraServ.mostrarExtra();
}

  @GetMapping("/detail/{id}")
    public ResponseEntity<Extra> getById(@PathVariable("id") Long id) {
        if (!extraServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Extra extra = extraServ.getOne(id).get();

        return new ResponseEntity(extra, HttpStatus.OK);
    }


@PostMapping("/crear")
public void crearExtra(@RequestBody Extra extra){
    extraServ.crearExtra(extra);
}

@PutMapping("/editar/{id}")
public Extra editarExtra(@RequestBody Extra extra, @PathVariable Long id){
    
    Extra ext = extraServ.encontrarExtra(id);
   
   ext.setSkill(extra.getSkill());
   ext.setPrograma(extra.getPrograma());
   
   
   
   extraServ.crearExtra(ext);
   return ext;
}


@DeleteMapping("/borrar/{id}")
public void borrarExtra(@PathVariable Long id){
    extraServ.borrarExtra(id);
}
}

