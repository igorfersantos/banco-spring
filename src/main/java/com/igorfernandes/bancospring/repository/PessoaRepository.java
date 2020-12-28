package com.igorfernandes.bancospring.repository;

import com.igorfernandes.bancospring.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
