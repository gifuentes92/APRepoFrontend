
package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EducacionRepository extends JpaRepository<Educacion,Long> {
    public Optional <Educacion> findByTitulo(String titulo);
    public boolean existsByTitulo (String titulo);
   
     public Optional <Educacion> findByInstitucion(String institucion);
    public boolean existsByInstitucion(String institucion);
    
     public Optional <Educacion> findByCurso(String curso);
    public boolean existsByCurso(String Curso);
    
    
    
    
}
