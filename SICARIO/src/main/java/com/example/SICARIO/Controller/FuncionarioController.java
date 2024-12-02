package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Funcionario;
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
public class FuncionarioController {

    @Autowired
    private Dados dados;

    /*@PostMapping("/guardar-funcionario")
    public String processarFuncionario(@ModelAttribute Funcionario func) {
        func.setId(dados.listaFunc.SIZE+1);
        dados.adicionarFunc(func);
        return "redirect:/CadastrarFuncionario";  
    }*/
    
    @PostMapping("/guardar-funcionario")
    public String processarFuncionario(@ModelAttribute Funcionario func) {
        func.setId(dados.listarFunc().size() + 1);

        dados.adicionarFunc(func);

        return "redirect:/CadastrarFuncionario";
    }

    
    @GetMapping("/excluir-funcionario/{id}")
    public String excluirFuncionario(@PathVariable Integer id, Model model) {
        dados.excluirFunc(id);
        return "redirect:/CadastrarFuncionario";
    }
    
    @GetMapping("/CadastrarFuncionario")
    public String CadastroFunc(Model model) {
        model.addAttribute("funcionarios", dados.listarFunc());  
        return "CadastroFunc";  
    }
}
