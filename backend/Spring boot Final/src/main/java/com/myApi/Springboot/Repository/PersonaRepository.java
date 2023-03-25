/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myApi.Springboot.Repository;

import com.myApi.Springboot.Model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    public Optional <Persona> findByNombre(String nombre);
    public boolean existsByNombre (String nombre);
    
    public Optional <Persona> findByUrlfoto(String urlfoto);
    public boolean existsByUrlfoto (String urlfoto);
   
     public Optional <Persona> findByAcercade(String acercade);
    public boolean existsByAcercade(String acercade);
    
     public Optional <Persona> findByPuesto(String puesto);
    public boolean existsByPuesto(String puesto);
    
    
    
    
}

