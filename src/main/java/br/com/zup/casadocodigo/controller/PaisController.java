package br.com.zup.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.NovoPaisDto;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.repository.PaisRepository;
import br.com.zup.casadocodigo.requests.PaisRequest;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<NovoPaisDto> cadastrar(@RequestBody @Valid PaisRequest request) {
		Pais pais = request.toModel();
		
		this.paisRepository.save(pais);
		
		return ResponseEntity.ok().body(new NovoPaisDto(pais));
	}
}