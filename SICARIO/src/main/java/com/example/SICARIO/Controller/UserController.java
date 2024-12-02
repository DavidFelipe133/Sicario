package com.example.SICARIO.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/")
    public String mostrar() {
        return "index"; 
    }

    @GetMapping("/tela-inicio")
    public String mostraIndex() {
        return "index"; 
    }

    /*@GetMapping("/Agendamentos")
    public String mostraAgendamentos() {
        return "GestaoAgendamentos"; 
    }*/
    /*
    @GetMapping("/Agendamentos/CadastrarAgendamento")
    public String CadastroAgendamentos() {
        return "CadastroAgendamento"; 
    }
    */
    /*@GetMapping("/Agendamentos/CadastrarCliente")
    public String CadastroCliente() {
        return "CadastroCliente"; 
    }*/

    @GetMapping("/sair")
    public String Sair() {
        return "index";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String username, @RequestParam String password, Model model) {

        if ("teste".equals(username) && "teste".equals(password)) {
            return "GestaoAgendamentos"; 
        } else {
            model.addAttribute("message", "Usuário ou senha inválidos.");
            return "index"; 
        }
    }
}
