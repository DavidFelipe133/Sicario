
package com.example.SICARIO.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    
    Integer id;
    String nome;
    String senha;   
}
