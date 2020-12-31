package com.igorfernandes.bancospring.exception;

import com.igorfernandes.bancospring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private PessoaService pessoaService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !pessoaService.existsByEmail(email);
    }
}
