
package com.myApi.miportfolio.Controller;

import com.myApi.miportfolio.Model.Skill;
import com.myApi.miportfolio.Service.SkillServicio;
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
///@CrossOrigin(origins ={"https://argentinaprograma-frontend.web.app"})
public class SkillControlador {
    
@Autowired
SkillServicio skillServ;
  
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