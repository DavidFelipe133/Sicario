
package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Agendamentos;
import com.example.SICARIO.Model.Cliente;
import com.example.SICARIO.Model.Dados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 

public class ClienteController {
    
    @Autowired
    private Dados dados;
    
    @PostMapping("/guardar-cliente")
    public String processarAgendamento(Model model,@ModelAttribute Cliente cliente){
        cliente.setId(dados.listarClientes().size()+1);
        
        dados.adicionarCliente(cliente);
        return "redirect:/CadastrarCliente";  
    } 
    @GetMapping("/excluir-cliente/{id}")
    public String excluirCliente(Model model, @PathVariable Integer id) {
        dados.excluirCliente(id);
        return "redirect:/CadastrarCliente";  

    }
    @GetMapping("/CadastrarCliente")
    public String CadastroCliente(Model model){
        model.addAttribute("clientes", dados.listarClientes());
        return "CadastroCliente"; 
    }
    
}
