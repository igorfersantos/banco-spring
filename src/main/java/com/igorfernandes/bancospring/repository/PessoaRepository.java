package com.igorfernandes.bancospring.repository;

import com.igorfernandes.bancospring.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

// Query creation:
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#appendix.query.method.subject
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Boolean existsByEmail(String email);
    Boolean existsByCpf(String cpf);
}
