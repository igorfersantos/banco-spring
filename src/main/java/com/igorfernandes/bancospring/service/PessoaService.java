package com.igorfernandes.bancospring.service;

import com.igorfernandes.bancospring.model.Pessoa;
import com.igorfernandes.bancospring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Boolean existsByEmail(String email){
        return pessoaRepository.existsByEmail(email);
    }

    public Boolean existsByCpf(String cpf){
        return pessoaRepository.existsByCpf(cpf);
    }

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }
}
