
package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Agendamentos;
import com.example.SICARIO.Model.Cliente;
import com.example.SICARIO.Model.Dados;
import com.example.SICARIO.Model.Funcionario;
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
//@RequestMapping("/agendamentos")

public class AgendaController {
    
    @Autowired
    private Dados dados;
    
/*
    @PostMapping("/guardar-agendamento")
    public String processarAgendamento(@ModelAttribute Agendamentos agendamento) {
        Cliente clienteSelecionado = Dados.obtemCliente(agendamento.getCliente().getId());
        Funcionario funcionarioSelecionado = Dados.obtemFunc(agendamento.getFunc().getId());

        agendamento.setCliente(clienteSelecionado);
        agendamento.setFunc(funcionarioSelecionado);

        agendamento.setId(Dados.listarAgenda().size() + 1);

        Dados.adicionarAgendamento(agendamento);

        return "redirect:/CadastrarAgendamento";
    }
*/
    @PostMapping("/guardar-agendamento")
    public String processarAgendamento(@ModelAttribute Agendamentos agendamento) {
        Cliente clienteSelecionado = Dados.obtemCliente(agendamento.getCliente().getId());
        Funcionario funcionarioSelecionado = Dados.obtemFunc(agendamento.getFunc().getId());

        agendamento.setCliente(clienteSelecionado);
        agendamento.setFunc(funcionarioSelecionado);

        if (agendamento.getId() == null) {

            agendamento.setId(Dados.listarAgenda().size() + 1); 
            Dados.adicionarAgendamento(agendamento);
        } else {
            dados.atualizarAgendamento(agendamento);
        }

        return "redirect:/Agendamentos"; 
    }

    
    
      @GetMapping("/agendamentos/excluir-agendamento/{id}")
    public String excluirAgendamento(Model model, @PathVariable Integer id) {
        dados.excluirAgenda(id);
  
        return "redirect:/Agendamentos";
    }
    @GetMapping("/cadastrarAgendamento/{id}")
    public String editarAgendamento(@PathVariable Integer id, Model model) {
        Agendamentos agendamento = dados.obtemAgenda(id);
        model.addAttribute("agendamento", agendamento);
        model.addAttribute("clientes", dados.listarClientes());
        model.addAttribute("funcionarios",dados.listarFunc());
        return "CadastroAgendamento";
    }
    /*
    @PostMapping("/atualizar")
    public String atualizarAgendamento(@ModelAttribute Agendamento agendamento) {
        dados.atualizarAgendamento(agendamento);
        return "redirect:/agendamentos";
    }*/
   
    @GetMapping("/CadastrarAgendamento")
    public String CadastroAgendamentos(Model model) {
        model.addAttribute("clientes", dados.listarClientes());
        model.addAttribute("funcionarios", dados.listarFunc());
        model.addAttribute("agendamento", new Agendamentos());
        return "CadastroAgendamento";
    }
    @GetMapping("/Agendamentos")
    public String mostraAgendamentos(Model model) {
        model.addAttribute("agendamentos", dados.listarAgenda());
        
        return "GestaoAgendamentos";
    }
    @GetMapping("/concluir/{id}")
    public String ConcluirAgenda(@PathVariable Integer id,Model model){
        Agendamentos agenda = dados.obtemAgenda(id);
        agenda.setStatus("Concluído");
        return "redirect:/Agendamentos";
    }
}
