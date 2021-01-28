package br.com.zup.casadocodigo.dto;

import java.time.LocalDate;

import br.com.zup.casadocodigo.model.Livro;

public class LivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private double preco;
	private int numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private String nomeAutor;
	private String nomeCategoria;
	
	public LivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.nomeAutor = livro.getAutor().getNome();
		this.nomeCategoria = livro.getCategoria().getNome();
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

	public double getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}
}