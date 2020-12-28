package com.igorfernandes.bancospring.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.igorfernandes.bancospring.model.Pessoa;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@JsonPropertyOrder({ "nome", "email", "cpf", "dataNascimento" })
@Value
public class PessoaDTO {

    @NotBlank(message = "O nome não pode ser vazio!")
    @Size(min = 3,max = 40, message = "o nome precisa ter entre {min} e {max} caracteres!")
    private String nome;

    @NotBlank(message = "E-mail precisa ser fornecido!")
    @Email(message = "E-mail inválido!")
    private String email;

    @NotBlank(message = "CPF não pode ser vazio!")
    private String cpf;

    @NotNull(message = "A data de nascimento precisa ser fornecida!")
    @Past(message = "A data precisa ser no passado!")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dataNascimento;

    public Pessoa transformaParaObjeto() {
        return new Pessoa(nome, email, cpf, dataNascimento);
    }
}
