
package com.myApi.miportfolio.Repository;

import com.myApi.miportfolio.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
