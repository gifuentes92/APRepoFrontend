
package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface localidadRepository extends JpaRepository<localidad, Long>{
    
}
