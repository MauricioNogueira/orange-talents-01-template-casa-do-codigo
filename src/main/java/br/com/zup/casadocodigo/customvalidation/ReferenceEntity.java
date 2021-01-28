package br.com.zup.casadocodigo.customvalidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ReferenceEntityValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ReferenceEntity {
	String message() default "Referência não foi encontrada no sistema";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
