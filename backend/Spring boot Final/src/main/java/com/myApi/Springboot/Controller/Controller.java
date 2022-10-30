
package com.myApi.Springboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    @GetMapping("/saludar")
    public String Saludar() {
        return "hola mundo!";
    }
    
    
}
