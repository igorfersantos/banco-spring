package com.igorfernandes.bancospring.service;

import com.igorfernandes.bancospring.model.Pessoa;
import com.igorfernandes.bancospring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

}
