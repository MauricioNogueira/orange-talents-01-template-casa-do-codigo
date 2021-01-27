package br.com.zup.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.AutorDto;
import br.com.zup.casadocodigo.forms.AutorRequest;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorRequest request) {
		Autor autor = request.toModel();
		this.autorRepository.save(autor);
		
		return ResponseEntity.ok().body(new AutorDto(autor));
	}
}