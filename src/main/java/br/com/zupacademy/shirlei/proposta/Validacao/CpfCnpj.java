package br.com.zupacademy.shirlei.proposta.Validacao;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@CPF
@CNPJ
@Documented
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {

    String message() default "Este CPF/CNPJ é inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
    String fieldName();
    Class<?> domainClass();

}
