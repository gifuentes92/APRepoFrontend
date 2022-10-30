
package com.myApi.miportfolio.Service;

import com.myApi.miportfolio.Model.Skill;
import com.myApi.miportfolio.Repository.SkillRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServicio {
    @Autowired
    SkillRepositorio skillRepo;
   
    
    public void crearSkill(Skill skill)  {
        skillRepo.save(skill);
    }
    
    public void borrarSkill(Long id){
        skillRepo.deleteById(id);
    }
    
    public List<Skill> mostrarSkill(){
      return  skillRepo.findAll();
    }

    public Skill encontrarSkill(Long id){
        Skill skill = skillRepo.findById(id).orElse(null);
        return skill;
    
}
    
}

