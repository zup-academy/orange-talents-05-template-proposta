package com.orange5.proposta.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;

@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@Constraint(validatedBy = { })
@Target({ FIELD })
@Retention(RUNTIME)
@CNPJ
@CPF
public @interface CPForCNPJ {

    String message() default "{javax.validation.constraints.CPForCNPJ.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}