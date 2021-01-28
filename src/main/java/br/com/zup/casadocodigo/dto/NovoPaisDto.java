package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Pais;

public class NovoPaisDto {

	private String nome;

	public NovoPaisDto(Pais pais) {
		this.nome = pais.getNome();
	}

	public String getNome() {
		return nome;
	}
}