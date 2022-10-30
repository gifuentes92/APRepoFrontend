
package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.conocimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface conocimientosRepository extends JpaRepository<conocimientos, Long>  {
    
}
