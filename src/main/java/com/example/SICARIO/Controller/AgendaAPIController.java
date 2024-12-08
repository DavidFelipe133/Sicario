
package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Agendamentos;
import com.example.SICARIO.Service.AgendamentosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamentos")
public class AgendaAPIController {
    
            @Autowired
            AgendamentosService agendamentosService;
            
            @GetMapping("/buscar/{id}")
            public ResponseEntity<Agendamentos> pesquisar(@PathVariable Integer id){
            Agendamentos agendamentoEncontrado = agendamentosService.buscarPorId(id);
            return new ResponseEntity<>(agendamentoEncontrado, HttpStatus.OK);
            }
            
            @PostMapping("/adicionar")
            public ResponseEntity<Agendamentos>criar(@RequestBody Agendamentos agendamento){
            Agendamentos novoAgendamento = agendamentosService.criarAgendamento(agendamento);
            return new ResponseEntity<>(novoAgendamento,HttpStatus.CREATED);
            }
            
            @GetMapping("/listar-todos")
            public ResponseEntity<List> listar() {
            List<Agendamentos> AgendamentoL = agendamentosService.listarTodos();
            return new ResponseEntity<>(AgendamentoL, HttpStatus.OK);
            }
            
            @PutMapping("/atualizar/{id}")
            public ResponseEntity<Agendamentos> atualizar(@PathVariable Integer id,@RequestBody Agendamentos agendamento){
            Agendamentos agendamentoEncontrado = agendamentosService.buscarPorId(id);
            agendamentoEncontrado.setFunc(agendamento.getFunc());
            agendamentoEncontrado.setCliente(agendamento.getCliente());
            agendamentoEncontrado.setDescricao(agendamento.getDescricao());
            agendamentoEncontrado.setValor(agendamento.getValor());
            
            agendamentosService.atualizar(id, agendamentoEncontrado);
            
            return new ResponseEntity<>(agendamentoEncontrado,HttpStatus.OK);
            }
              
            @DeleteMapping("excluir/{id}")
            public ResponseEntity<?>deletar(@PathVariable Integer id){
            agendamentosService.excluir(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }  
            @PutMapping("/concluir/{id}")
            public ResponseEntity<Agendamentos>concluir(@PathVariable Integer id,@RequestBody Agendamentos agendamento){
            Agendamentos agendamentoEncontrado = agendamentosService.buscarPorId(id);
            agendamentoEncontrado.setStatus("Concluído");
            
            return new ResponseEntity<>(agendamentoEncontrado,HttpStatus.OK);
            }
}
