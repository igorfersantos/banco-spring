package com.igorfernandes.bancospring.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.igorfernandes.bancospring.model.Pessoa;
import lombok.Value;

@JsonPropertyOrder({"id", "nome", "email"})
@Value
public class PessoaRespostaDTO {
    private Long id;
    private String nome;
    private String email;

    public static PessoaRespostaDTO transformaEmDTO(Pessoa pessoa) {
        return new PessoaRespostaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
    }
}
