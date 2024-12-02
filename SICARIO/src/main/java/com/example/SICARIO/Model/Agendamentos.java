
package com.example.SICARIO.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Agendamentos {
    
    
    Integer id;
    Cliente cliente;
    Funcionario func;
    String descricao;
    String valor;
    String status = "A Fazer";
    
    
  
}
