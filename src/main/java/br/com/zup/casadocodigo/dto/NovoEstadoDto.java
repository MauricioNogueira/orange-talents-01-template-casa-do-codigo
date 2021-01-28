package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Estado;

public class NovoEstadoDto {

	private String nome;
	private String nomePais;
	
	public NovoEstadoDto(Estado estado) {
		this.nome = estado.getNome();
		this.nomePais = estado.getPais().getNome();
	}

	public String getNome() {
		return nome;
	}

	public String getNomePais() {
		return nomePais;
	}
}