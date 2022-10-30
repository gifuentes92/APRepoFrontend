
package com.myApi.miportfolio.Service;

import com.myApi.miportfolio.Model.Login;
import com.myApi.miportfolio.Repository.LoginRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServicio {
@Autowired
    LoginRepositorio loginRepo;
    public boolean iniciarSesion(Login log) {
        return loginRepo.existsByUsernameAndPass(log.getUsername(), log.getPass());
    }
    
    public void crear(Login login)
    {
        loginRepo.save(login);
    }
    
}
