
package com.myApi.miportfolio.Repository;

import com.myApi.miportfolio.Model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaRepositorio extends JpaRepository<Idioma, Long> {
    
}
