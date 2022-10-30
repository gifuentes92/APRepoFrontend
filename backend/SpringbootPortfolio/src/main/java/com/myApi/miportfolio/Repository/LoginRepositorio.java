package com.myApi.miportfolio.Repository;


import com.myApi.miportfolio.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepositorio extends JpaRepository<Login, Long>{
public boolean existsByUsernameAndPass(String username, String pass);
    
}