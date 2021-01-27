package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.forms.CategoriaRequest;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequest request) {
		System.out.println("Passou");
		return null;
	}
}