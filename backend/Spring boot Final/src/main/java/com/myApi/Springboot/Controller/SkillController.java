
package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Model.Skill;
import com.myApi.Springboot.Security.Controller.Mensaje;
import com.myApi.Springboot.Services.SkillService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class SkillController {
    
@Autowired
SkillService skillServ;
  
@GetMapping("/skill/mostrar")
@ResponseBody
public List<Skill> mostrarSkill(){
    
    return skillServ.mostrarSkill();
}

  @GetMapping("/skill/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") Long id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = skillServ.getOne(id).get();

        return new ResponseEntity(skill, HttpStatus.OK);
    }

@PostMapping("/skill/crear")
public void crearSkill(@RequestBody Skill skill){
    skillServ.crearSkill(skill);
}

@PutMapping("/skill/editar/{id}")
public Skill editarSkill(@RequestBody Skill skill, @PathVariable Long id){
    
    Skill ski = skillServ.encontrarSkill(id);
   
   ski.setSkill(skill.getSkill());
   
   
   
   
  skillServ.crearSkill(ski);
   return ski;
}


@DeleteMapping("/skill/borrar/{id}")
public void borrarSkill(@PathVariable Long id){
    skillServ.borrarSkill(id);
}
}