
package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Cliente;
import com.example.SICARIO.Service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
@RequestMapping("/Cliente")
public class ClienteAPIController {
    
            @Autowired
            ClienteService clienteService;
            
            
            @GetMapping("buscar/{id}")
            public ResponseEntity<Cliente> pesquisar(@PathVariable Integer id){
            Cliente clienteEncontrado = clienteService.buscarPorId(id);
            return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
            }
            
            @PostMapping("/adicionar")
            public ResponseEntity<Cliente>criar(@RequestBody Cliente cliente){
            Cliente novoCliente = clienteService.criarCliente(cliente);
            return new ResponseEntity<>(novoCliente,HttpStatus.CREATED);
            }
            
            @GetMapping("/listar-todos")
            public ResponseEntity<List> listar() {
            List<Cliente> ClienteL = clienteService.listarTodos();
            return new ResponseEntity<>(ClienteL, HttpStatus.OK);
            }
            
            @PutMapping("/atualizar/{id}")
            public ResponseEntity<Cliente> atualizar(@PathVariable Integer id,@RequestBody Cliente cliente){
            Cliente clienteEncontrado = clienteService.atualizar(id, cliente);
            return new ResponseEntity<>(clienteEncontrado,HttpStatus.OK);
        }
        
            @DeleteMapping("/excluir/{id}")
            public ResponseEntity<?>deletar(@PathVariable Integer id){
            clienteService.excluir(id);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
}
