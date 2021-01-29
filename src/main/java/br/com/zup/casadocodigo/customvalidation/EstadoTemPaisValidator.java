package br.com.zup.casadocodigo.customvalidation;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import br.com.zup.casadocodigo.repository.PaisRepository;
import br.com.zup.casadocodigo.requests.FechaCompraRequest;

@Component
public class EstadoTemPaisValidator implements Validator {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return FechaCompraRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if (errors.hasErrors()) {
			return;
		}
		
		FechaCompraRequest request = (FechaCompraRequest) target;
		
		Optional<Pais> optionalPais = this.paisRepository.findById(request.getPaisId());
		Pais pais = optionalPais.get();
		
		if (!pais.getEstados().isEmpty() && request.getEstadoId() == null) {
			errors.rejectValue("estadoId", null, "não foi possível encontrar estado com este valor");
		}
		
		Optional<Estado> optionalEstado = this.estadoRepository.findById(request.getEstadoId());
		Estado estado = optionalEstado.get();
		
		if (!estado.getPais().equals(pais)) {
			errors.rejectValue("estadoId", null, "estado não pertence ao país selecionado");
		}
	}
}
