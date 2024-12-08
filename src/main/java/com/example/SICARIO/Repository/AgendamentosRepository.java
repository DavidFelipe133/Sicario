
package com.example.SICARIO.Repository;

import com.example.SICARIO.Model.Agendamentos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentosRepository extends JpaRepository<Agendamentos, Integer>{
    List<Agendamentos>findByid(Integer id);
}
