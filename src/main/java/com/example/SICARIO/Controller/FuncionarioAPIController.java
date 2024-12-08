
package com.example.SICARIO.Controller;

import com.example.SICARIO.Model.Funcionario;
import com.example.SICARIO.Service.FuncionarioService;
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
@RequestMapping("/Funcionario")
public class FuncionarioAPIController {
    
        @Autowired
        FuncionarioService funcionarioService;
        
        @GetMapping("buscar/{id}")
        public ResponseEntity<Funcionario> pesquisar(@PathVariable Integer id){
             Funcionario funcionarioEncontrado = funcionarioService.buscarPorId(id);
             return new ResponseEntity<>(funcionarioEncontrado, HttpStatus.OK);
        }
        
        
        @PostMapping("/adicionar")
        public ResponseEntity<Funcionario>criar(@RequestBody Funcionario funcionario){
        Funcionario novoFunc = funcionarioService.criarFuncionario(funcionario);
        return new ResponseEntity<>(novoFunc,HttpStatus.CREATED);
        }
        
        @GetMapping("/listar-todos")
        public ResponseEntity<List>listar(){
        List<Funcionario>FuncionarioL = funcionarioService.listarTodos();
        return new ResponseEntity<>(FuncionarioL,HttpStatus.OK);
        }
        
        @PutMapping("/atualizar/{id}")
        public ResponseEntity<Funcionario> atualizar(@PathVariable Integer id,@RequestBody Funcionario funcionario){
            Funcionario funcEncontrado = funcionarioService.atualizar(id, funcionario);
            return new ResponseEntity<>(funcEncontrado,HttpStatus.OK);
        }
        
        @DeleteMapping("/excluir/{id}")
        public ResponseEntity<?>deletar(@PathVariable Integer id){
            funcionarioService.excluir(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }   
}
