
package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillRepository extends JpaRepository<Skill, Long>{
    
}
