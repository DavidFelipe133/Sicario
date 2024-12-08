
package com.example.SICARIO.Service;

import com.example.SICARIO.Model.Funcionario;
import com.example.SICARIO.Repository.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class FuncionarioService {
        @Autowired
        FuncionarioRepository funcionarioRepository;
        
        public Funcionario buscarPorId(Integer id){
            return funcionarioRepository.findById(id).orElseThrow();
        }
        public Funcionario criarFuncionario(Funcionario funcionario){
            funcionario.setId(null);
            funcionarioRepository.save(funcionario);
            return funcionario;
        }
        public List<Funcionario>listarTodos(){
            return funcionarioRepository.findAll();
        }
        public Funcionario atualizar(Integer id,Funcionario funcionario){
            Funcionario funcionarioEncontrado = buscarPorId(id);
            funcionarioEncontrado.setNome(funcionario.getNome());
            return funcionarioEncontrado;
        }
        
        
        public void excluir (Integer id){
            Funcionario funcionario = buscarPorId(id);
            funcionarioRepository.deleteById(id);
        }
    
}
