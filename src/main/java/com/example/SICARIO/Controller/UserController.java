package com.example.SICARIO.Controller;

import com.example.SICARIO.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String processarLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.validarCredenciais(username, password)) {
            return "redirect:/Agendamentos"; 
        } else {
            model.addAttribute("message", "Usuário ou senha inválidos.");
            return "index"; 
        }
    }
    @GetMapping("/tela-inicio")
    public String mostraIndex() {
        return "index"; 
    }
    

}
