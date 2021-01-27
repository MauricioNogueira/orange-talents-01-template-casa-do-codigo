package br.com.zup.casadocodigo.handle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zup.casadocodigo.dto.ValidacaoDto;

@RestControllerAdvice
public class HandleValidations {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ValidacaoDto> handle(MethodArgumentNotValidException exception) {
		List<ValidacaoDto> erros = new ArrayList<>();
		
		exception.getFieldErrors().forEach(error -> {
			erros.add(new ValidacaoDto(error.getField(), error.getDefaultMessage()));
		});
		
		return erros;
	}
}
