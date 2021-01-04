package com.igorfernandes.bancospring.validation;

import com.igorfernandes.bancospring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String>{

    @Autowired
    private PessoaService pessoaService;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return !pessoaService.existsByCpf(cpf);
    }
}
