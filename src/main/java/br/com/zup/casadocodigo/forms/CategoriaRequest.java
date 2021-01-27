package br.com.zup.casadocodigo.forms;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.customvalidation.UniqueValue;
import br.com.zup.casadocodigo.model.Categoria;

public class CategoriaRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}