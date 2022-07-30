/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myApi.Springboot.Service;

import com.myApi.Springboot.Model.provincia;
import com.myApi.Springboot.Repository.provinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class provinciaService {
    
    @Autowired
    provinciaRepository provinciaRepo;
    
    
     public List<provincia> listarProvincia(){
    return provinciaRepo.findAll();
    }
    
    public provincia buscarLocalidadPorId(Long id)
    {
        return provinciaRepo.findById(id).orElse(null);
    }
    
}
