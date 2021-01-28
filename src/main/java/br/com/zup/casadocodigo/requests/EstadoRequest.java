package br.com.zup.casadocodigo.requests;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.customvalidation.ReferenceEntity;
import br.com.zup.casadocodigo.customvalidation.UniqueValue;
import br.com.zup.casadocodigo.exception.EntityNotFoundException;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.repository.PaisRepository;

public class EstadoRequest {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
	@ReferenceEntity
	private Long paisId;

	public EstadoRequest(String nome, Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}

	@Override
	public String toString() {
		return "EstadoRequest [nome=" + nome + ", paisId=" + paisId + "]";
	}

	public Estado toModel(PaisRepository paisRepository) {
		Optional<Pais> optionalPais = paisRepository.findById(this.paisId);
		
		if (optionalPais.isPresent()) {			
			return new Estado(this.nome, optionalPais.get());
		}
		
		throw new EntityNotFoundException("Não possível cadastrar estado");
	}
}