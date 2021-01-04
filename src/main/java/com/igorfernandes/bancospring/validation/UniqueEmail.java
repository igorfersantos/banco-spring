package com.igorfernandes.bancospring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueEmailValidator.class})
public @interface UniqueEmail {
    String message() default "Email já cadastrado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
