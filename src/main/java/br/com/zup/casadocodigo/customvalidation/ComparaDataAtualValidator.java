package br.com.zup.casadocodigo.customvalidation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ComparaDataAtualValidator implements ConstraintValidator<ComparaDataAtual, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		
		if (value.compareTo(LocalDate.now()) > 0) {
			return true;
		}
		
		return false;
	}
}