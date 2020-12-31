package com.igorfernandes.bancospring.controller;

import com.igorfernandes.bancospring.dto.PessoaDTO;
import com.igorfernandes.bancospring.dto.PessoaRespostaDTO;
import com.igorfernandes.bancospring.model.Pessoa;
import com.igorfernandes.bancospring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/pessoas")
@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody PessoaDTO pessoaDTO) {
        pessoaService.save(pessoaDTO.transformaParaObjeto());
        return new ResponseEntity<>("Usuário criado!", HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PessoaRespostaDTO> listar() {

        return pessoaService
                .findAll()
                .stream()
                .map(PessoaRespostaDTO::transformaEmDTO)
                .collect(Collectors.toList());
    }
}
