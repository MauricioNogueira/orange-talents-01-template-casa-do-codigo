package br.com.zup.casadocodigo.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrecoMinimoValidator implements ConstraintValidator<PrecoMinimo, Double> {
	
	private double preco;
	
	@Override
	public void initialize(PrecoMinimo constraintAnnotation) {
		this.preco = constraintAnnotation.preco();
	}


	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		int result = Double.compare(value, this.preco);
		
		if (result >= 0) {
			return true;
		}
		
		return false;
	}
}
