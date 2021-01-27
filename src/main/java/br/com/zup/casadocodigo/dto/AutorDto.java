package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Autor;

public class AutorDto {
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	
	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
}
