package br.com.zup.casadocodigo.handle;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zup.casadocodigo.dto.ErrorResponseDto;

@RestControllerAdvice
public class HandleValidacaoDeIntegridade {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorResponseDto handle(DataIntegrityViolationException exception) {
		
		return new ErrorResponseDto("Falha interno no sistema", HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}