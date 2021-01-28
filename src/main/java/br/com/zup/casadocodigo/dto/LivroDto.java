package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Livro;

public class LivroDto {

	private Long id;
	private String titulo;
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public String getTitulo() {
		return titulo;
	}
	
	public Long getId() {
		return this.id;
	}
}