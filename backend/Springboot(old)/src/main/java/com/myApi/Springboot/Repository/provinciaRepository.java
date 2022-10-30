
package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface provinciaRepository extends JpaRepository<provincia, Long> {
    
}
