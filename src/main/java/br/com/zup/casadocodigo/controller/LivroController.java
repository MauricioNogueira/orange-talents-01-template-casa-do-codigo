package br.com.zup.casadocodigo.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.casadocodigo.dto.LivroDto;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import br.com.zup.casadocodigo.repository.LivroRepository;
import br.com.zup.casadocodigo.requests.LivroRequest;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroRequest request, UriComponentsBuilder uriBuilder) {
		Livro livro = request.toModel(this.autorRepository, this.categoriaRepository);
		
		this.livroRepository.save(livro);
		
		URI location = uriBuilder.path("/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(location).body(new LivroDto(livro));
	}
}
