

package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface educacionRepository extends JpaRepository<educacion, Long> {
    
}
