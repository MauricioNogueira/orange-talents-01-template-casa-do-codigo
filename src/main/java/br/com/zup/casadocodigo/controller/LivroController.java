package br.com.zup.casadocodigo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.DetalheLivroDto;
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
	public ResponseEntity<Livro> cadastrar(@RequestBody @Valid LivroRequest request) {
		Livro livro = request.toModel(this.autorRepository, this.categoriaRepository);
		
		this.livroRepository.save(livro);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public List<LivroDto> listar() {
		List<LivroDto> livros = this.livroRepository.findAll().stream().map(LivroDto::new).collect(Collectors.toList());
		
		return livros;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroDto> detalhe(@PathVariable Long id) {
		Optional<Livro> optional = this.livroRepository.findById(id);
		
		if (optional.isPresent()) {
			return ResponseEntity.ok().body(new DetalheLivroDto(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
