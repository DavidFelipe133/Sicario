
package com.example.SICARIO.Service;

import com.example.SICARIO.Model.User;
import com.example.SICARIO.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    
     @Autowired
    private UserRepository userRepository;

    public boolean validarCredenciais(String nome, String senha) {
        User usuario = userRepository.findByNome(nome);
        return usuario != null && usuario.getSenha().equals(senha);
    }
    
    
}
