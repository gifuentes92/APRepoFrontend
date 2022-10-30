
package com.myApi.miportfolio.Repository;

import com.myApi.miportfolio.Model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducacionRepositorio extends JpaRepository<Educacion, Long> {
    
}
