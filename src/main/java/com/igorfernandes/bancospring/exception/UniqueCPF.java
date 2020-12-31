package com.igorfernandes.bancospring.exception;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueCPFValidator.class})
public @interface UniqueCPF {
    String message() default "CPF já cadastrado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
