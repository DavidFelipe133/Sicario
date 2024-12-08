
package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Agendamentos;
import com.example.SICARIO.Model.Cliente;
import com.example.SICARIO.Model.Dados;
import com.example.SICARIO.Service.AgendamentosService;
import com.example.SICARIO.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    ClienteService clienteService;
    
    @PostMapping("/guardar-cliente")
    public String processarAgendamento(Model model,@ModelAttribute Cliente cliente){
        cliente.setId(null);
        clienteService.criarCliente(cliente);
        return "redirect:/CadastrarCliente";  
    }
    
    @GetMapping("/excluir-cliente/{id}")
    public String excluirCliente(Model model, @PathVariable Integer id, @ModelAttribute Cliente cliente) {
        try {
            clienteService.excluir(id);
            return "redirect:/CadastrarCliente";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", "Não foi possível excluir o cliente, pois há agendamentos relacionados.");
            model.addAttribute("clientes", clienteService.listarTodos());
            return "CadastroCliente";

        }

    }
    @GetMapping("/CadastrarCliente")
    public String CadastroCliente(Model model){
        model.addAttribute("clientes", clienteService.listarTodos());
        return "CadastroCliente"; 
    }
    
}
