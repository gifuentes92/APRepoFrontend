/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.Springboot.Service;

import com.myApi.Springboot.Model.Educacion;
import java.util.List;

/**
 *
 * @author Woneja
 */
public class conocimentoService {
    public void crearEducacion(Educacion educacion)
    {
        educacionRepo.save(educacion);
    }
    
    public void borrarEducacion(Long id){
        educacionRepo.deleteById(id);
    }
    
    public List<Educacion> mostrarEducacion(){
      return  educacionRepo.findAll();
    }

    public Educacion encontrarEducacion(Long id){
        Educacion educacion = educacionRepo.findById(id).orElse(null);
        return educacion;
    }
    
    public void editarEducacion (Educacion educacion){
    educacionRepo.save(educacion);
    }
    
}

}
