package br.com.zup.casadocodigo.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class CPFOuCNPJValidator implements ConstraintValidator<CPFOuCNPJ, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		CPFValidator validatorCpf = new CPFValidator();
		CNPJValidator validadorCnpj = new CNPJValidator();
		validatorCpf.initialize(null);
		validadorCnpj.initialize(null);
		
		boolean result = (validatorCpf.isValid(value, null) || validadorCnpj.isValid(value, null));
		
		return result;
	}
}