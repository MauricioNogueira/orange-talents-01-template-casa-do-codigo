package br.com.zup.casadocodigo.customvalidation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {
	
	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		this.domainAttribute = constraintAnnotation.fieldName();
		this.klass = constraintAnnotation.domainClass();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		
		return list.size() < 1;
	}
	
}
