package com.myApi.Springboot.Services;

import com.myApi.Springboot.Model.Skill;
import com.myApi.Springboot.Repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepo;

    public void crearSkill(Skill skill) {
        skillRepo.save(skill);
    }

    public void borrarSkill(Long id) {
        skillRepo.deleteById(id);
    }

    public List<Skill> mostrarSkill() {
        return skillRepo.findAll();
    }

    public Skill encontrarSkill(Long id) {
        Skill skill = skillRepo.findById(id).orElse(null);
        return skill;

    }
    
     public Optional<Skill> getOne(Long id) {
          return skillRepo.findById(id);
      }
    
       public boolean existsById(Long Id) {
          return skillRepo.existsById(Id);
      }

}
