package com.myApi.miportfolio.Repository;

import com.myApi.miportfolio.Model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto,Long> {
    
}
