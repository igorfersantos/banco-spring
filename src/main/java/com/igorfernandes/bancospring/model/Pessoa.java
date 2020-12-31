package com.igorfernandes.bancospring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
//@Table(
//        indexes = {
//                @Index(name = "idx_email", columnList = "email", unique = true),
//                @Index(name = "idx_cpf", columnList = "cpf", unique = true)
//        }
//)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Pessoa(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

}
