
package com.myApi.miportfolio.Repository;

import com.myApi.miportfolio.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillRepositorio extends JpaRepository<Skill,Long> {
    
}
