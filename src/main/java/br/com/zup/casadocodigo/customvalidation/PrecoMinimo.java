package br.com.zup.casadocodigo.customvalidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PrecoMinimoValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PrecoMinimo {
	String message() default "Valor abaixo do esperado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    double preco();
}