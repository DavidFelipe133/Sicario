package com.example.SICARIO.Repository;

import com.example.SICARIO.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNome(String nome);
}
