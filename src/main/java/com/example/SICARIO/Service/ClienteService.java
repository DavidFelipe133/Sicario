
package com.example.SICARIO.Service;

import com.example.SICARIO.Model.Cliente;
import com.example.SICARIO.Repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.standard.expression.OrExpression;


@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository; 
    
        public Cliente buscarPorId(Integer id){
            return clienteRepository.findById(id).orElseThrow();
        }
        public Cliente criarCliente(Cliente cliente){  
            cliente.setId(null);
            clienteRepository.save(cliente);
            return cliente;
        }
        public List<Cliente>listarTodos(){
            return clienteRepository.findAll();
        }
        public Cliente atualizar(Integer id,Cliente cliente){
            Cliente clienteEncontrado = buscarPorId(id);
            clienteEncontrado.setNome(cliente.getNome());
            return clienteEncontrado;
        }
        public void excluir (Integer id){
            Cliente cliente = buscarPorId(id);
            clienteRepository.deleteById(cliente.getId());
        }
    
}
