
package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Model.Skill;
import com.myApi.Springboot.Services.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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


@DeleteMapping("/skill/{id}")
public void borrarSkill(@PathVariable Long id){
    skillServ.borrarSkill(id);
}
}