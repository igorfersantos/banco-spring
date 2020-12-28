package com.igorfernandes.bancospring.controller;

import com.igorfernandes.bancospring.dto.PessoaDTO;
import com.igorfernandes.bancospring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/pessoas")
@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody PessoaDTO pessoaDTO){
        return new ResponseEntity<>("funcionou", HttpStatus.CREATED);
    }
}
