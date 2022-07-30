
package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface extraRepository extends JpaRepository<extra, Long> {
    
}
