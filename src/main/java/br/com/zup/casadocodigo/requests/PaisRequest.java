package br.com.zup.casadocodigo.requests;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.casadocodigo.customvalidation.UniqueValue;
import br.com.zup.casadocodigo.model.Pais;

public class PaisRequest {
	
	@NotBlank
	@Column(unique = true)
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	/**
	 * Para evitar problema de serialização com o Jackson, você pode colocar um construtor padrão na classe,
	 * ou adiciona a anotação @JsonCreator no construtor
	 */
	
	@JsonCreator
	public PaisRequest(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
}