package br.com.zup.casadocodigo.requests;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.customvalidation.UniqueValue;
import br.com.zup.casadocodigo.model.Categoria;

public class CategoriaRequest {
	
	@NotBlank
	@Column(unique = true)
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		
		return new Categoria(this.nome);
	}
}