

package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
    
}