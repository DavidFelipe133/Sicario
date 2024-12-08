
package com.example.SICARIO.Repository;

import com.example.SICARIO.Model.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
     List<Funcionario> findByid(Integer id);
}
