
package com.myApi.Springboot.Services;

import com.myApi.Springboot.Model.Educacion;
import com.myApi.Springboot.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

  @Service
  @Transactional
public class EducacionService {


    @Autowired
    EducacionRepository educacionRepo;
     
      public List<Educacion> list() {
          return educacionRepo.findAll();
      }

      public Optional<Educacion> getOne(Long id) {
          return educacionRepo.findById(id);
      }

      public Optional<Educacion> mostrarPorTitulo(String titulo) {
          return educacionRepo.findByTitulo(titulo);
      }
      
      public Optional<Educacion> mostrarPorInstitucion(String institucion) {
          return educacionRepo.findByInstitucion(institucion);
      }
      
      public Optional<Educacion> mostrarPorCurso(String curso) {
          return educacionRepo.findByCurso(curso);
      }
      
      

      public void save(Educacion educacion) {
          educacionRepo.save(educacion);
      }

      public void delete(Long id) {
          educacionRepo.deleteById(id);
      }

      public Educacion  update(Long id) {
          Educacion educacion = educacionRepo.findById(id).orElse(null);
          return educacion;
      }

      public boolean existsById(Long Id) {
          return educacionRepo.existsById(Id);
      }

      public boolean existePorTitulo(String titulo) {
          return educacionRepo.existsByTitulo(titulo);
      }
      
      public boolean existePorInstitucion(String institucion) {
          return educacionRepo.existsByInstitucion(institucion);
      }

public boolean existePorCurso(String curso) {
          return educacionRepo.existsByCurso(curso);
      }
    

  }

