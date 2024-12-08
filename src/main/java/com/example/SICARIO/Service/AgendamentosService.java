
package com.example.SICARIO.Service;

import com.example.SICARIO.Model.Agendamentos;
import com.example.SICARIO.Repository.AgendamentosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AgendamentosService {
        @Autowired
        AgendamentosRepository agendamentoRepository;
        
        public Agendamentos buscarPorId(Integer id){
                return agendamentoRepository.findById(id).orElseThrow();    
        }
        public Agendamentos criarAgendamento(Agendamentos agendamento){
            agendamento.setId(null);
            agendamentoRepository.save(agendamento);
            return agendamento;
        }
        public List<Agendamentos>listarTodos(){
            return agendamentoRepository.findAll();
        }
        public Agendamentos atualizar(Integer id, Agendamentos agendamento){
            Agendamentos agendaEncontrada = buscarPorId(agendamento.getId());
            agendaEncontrada.setCliente(agendamento.getCliente());
            agendaEncontrada.setDescricao(agendamento.getDescricao());
            agendaEncontrada.setFunc(agendamento.getFunc());
            agendaEncontrada.setValor(agendamento.getValor());
            agendamentoRepository.save(agendaEncontrada);
            return agendaEncontrada;
        }
    
        public void excluir (Integer id){
            Agendamentos agenda = buscarPorId(id);
            agendamentoRepository.deleteById(agenda.getId());
        }
    public void concluirAgendamento(Integer id) {
        Agendamentos agendamento = buscarPorId(id);
        agendamento.setStatus("Concluído"); 
       
        agendamentoRepository.save(agendamento);
    }


}
