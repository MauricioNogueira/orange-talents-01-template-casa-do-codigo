package br.com.zup.casadocodigo.dto;

import java.math.BigDecimal;

import br.com.zup.casadocodigo.model.Livro;

public class DetalheLivroDto {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private String isbn;
	private int numeroPaginas;
	private String nomeAutor;
	
	public DetalheLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.isbn = livro.getIsbn();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.nomeAutor = livro.getAutor().getNome();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}
}