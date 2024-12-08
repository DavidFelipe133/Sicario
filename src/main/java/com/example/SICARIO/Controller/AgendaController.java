
package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Agendamentos;
import com.example.SICARIO.Model.Cliente;
import com.example.SICARIO.Model.Dados;
import com.example.SICARIO.Model.Funcionario;
import com.example.SICARIO.Service.AgendamentosService;
import com.example.SICARIO.Service.ClienteService;
import com.example.SICARIO.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 

public class AgendaController {
    
    @Autowired
    AgendamentosService agendamentoService;
    
    @Autowired
    ClienteService clienteService;
    
    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/guardar-agendamento")
    public String processarAgendamento(@ModelAttribute Agendamentos agendamento) {
        Cliente clienteSelecionado = clienteService.buscarPorId(agendamento.getCliente().getId());
        Funcionario funcionarioSelecionado = funcionarioService.buscarPorId(agendamento.getFunc().getId());
        
        agendamento.setCliente(clienteSelecionado);
        agendamento.setFunc(funcionarioSelecionado);

        if (agendamento.getId() == null) {
            
            agendamentoService.criarAgendamento(agendamento);
        } else if(agendamento.getId()!=null){
            
            agendamentoService.atualizar(agendamento.getId(), agendamento);           
        }

        return "redirect:/Agendamentos"; 
    }

    
    
      @GetMapping("/agendamentos/excluir-agendamento/{id}")
    public String excluirAgendamento(Model model, @PathVariable Integer id){
        agendamentoService.excluir(id);
  
        return "redirect:/Agendamentos";
    }
    @GetMapping("/cadastrarAgendamento/{id}")
    public String editarAgendamento(@PathVariable Integer id, Model model) {
        Agendamentos agendamento = agendamentoService.buscarPorId(id);
        model.addAttribute("agendamento", agendamento);
        
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("funcionarios",funcionarioService.listarTodos());
        
        return "CadastroAgendamento";
    }

    @GetMapping("/CadastrarAgendamento")
    public String CadastroAgendamentos(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        model.addAttribute("agendamento", new Agendamentos());
        return "CadastroAgendamento";
    }
    @GetMapping("/Agendamentos")
    public String mostraAgendamentos(Model model) {
        model.addAttribute("agendamentos", agendamentoService.listarTodos());

        return "GestaoAgendamentos";
    }
    @GetMapping("/concluir/{id}")
    public String concluirAgenda(@PathVariable Integer id) {
        agendamentoService.concluirAgendamento(id);
        return "redirect:/Agendamentos";
    }

}
