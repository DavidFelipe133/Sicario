package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Cliente;
import com.example.SICARIO.Model.Funcionario;
import com.example.SICARIO.Model.Dados;
import com.example.SICARIO.Service.FuncionarioService;
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
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;
    
    @PostMapping("/guardar-funcionario")
    public String processarFuncionario(@ModelAttribute Funcionario func) {
        func.setId(null);
        funcionarioService.criarFuncionario(func);
        return "redirect:/CadastrarFuncionario";
    }

    
    @GetMapping("/excluir-funcionario/{id}")
    public String excluirFuncionario(@PathVariable Integer id, Model model,@ModelAttribute Funcionario funcionario) {
        try{        
        funcionarioService.excluir(id);
        return "redirect:/CadastrarFuncionario";
        }catch(DataIntegrityViolationException e){
            model.addAttribute("errorMessage", "Não foi possível excluir o funcionario, pois há agendamentos relacionados.");
            model.addAttribute("funcionarios", funcionarioService.listarTodos());
            return "CadastroFunc";

        }
    }
    
    @GetMapping("/CadastrarFuncionario")
    public String CadastroFunc(Model model) {
        model.addAttribute("funcionarios", funcionarioService.listarTodos());  
        return "CadastroFunc";  
    }
}
