package br.com.zup.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.NovoEstadoDto;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import br.com.zup.casadocodigo.repository.PaisRepository;
import br.com.zup.casadocodigo.requests.EstadoRequest;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<NovoEstadoDto> cadastrar(@RequestBody @Valid EstadoRequest request) {
		Estado estado = request.toModel(this.paisRepository);
		
		this.estadoRepository.save(estado);
		
		return ResponseEntity.ok().body(new NovoEstadoDto(estado));
	}
}