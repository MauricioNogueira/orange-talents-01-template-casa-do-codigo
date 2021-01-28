package br.com.zup.casadocodigo.customvalidation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.repository.PaisRepository;

public class ReferenceEntityValidator implements ConstraintValidator<ReferenceEntity, Long> {
	
	@Autowired
	private PaisRepository paisRepository;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Optional<Pais> optional = this.paisRepository.findById(value);
		
		if (optional.isPresent()) {
			return true;
		}
		
		return false;
	}
}