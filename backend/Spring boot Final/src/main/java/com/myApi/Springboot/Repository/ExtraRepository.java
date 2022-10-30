
package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.Extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends JpaRepository<Extra,Long> {
    
}
