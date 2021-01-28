package br.com.zup.casadocodigo.requests;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.customvalidation.UniqueValue;
import br.com.zup.casadocodigo.exception.EntityNotFoundException;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;

public class LivroRequest {
	
	@NotBlank
	@Column(unique = true)
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	
	@NotNull
	@Min(value = 100)
	private int numeroPaginas;
	
	@NotBlank
	@Column(unique = true)
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;
	
	@NotNull
	private Long autorId;
	
	@NotNull
	private Long categoriaId;

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
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

	public Long getAutorId() {
		return autorId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	@Override
	public String toString() {
		return "LivroRequest [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", autorId=" + autorId + ", categoriaId=" + categoriaId + "]";
	}

	public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Optional<Autor> optionalAutor = autorRepository.findById(this.autorId);
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(this.categoriaId);
		
		if (optionalAutor.isPresent() && optionalCategoria.isPresent()) {
			return new Livro(this.titulo, this.resumo, this.sumario, this.preco, 
					this.numeroPaginas, this.isbn, this.dataPublicacao, optionalAutor.get(), optionalCategoria.get());
		}
		
		throw new EntityNotFoundException("Não foi possível cadastrar o livro");
	}
}