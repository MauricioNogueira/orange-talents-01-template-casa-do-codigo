package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.customvalidation.EstadoTemPaisValidator;
import br.com.zup.casadocodigo.requests.FechaCompraRequest;

@RestController
@RequestMapping("/fechar-compra")
public class FechaCompraController {
	
	@Autowired
	private EstadoTemPaisValidator estadoTemPaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(this.estadoTemPaisValidator);
	}

	@PostMapping
	public void fechar(@RequestBody @Valid FechaCompraRequest request) {
		request.toModel();
		System.out.println("Fechando compra...");
		
		System.out.println(request);
	}
}