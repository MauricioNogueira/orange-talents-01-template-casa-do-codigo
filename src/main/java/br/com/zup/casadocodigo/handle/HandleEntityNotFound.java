package br.com.zup.casadocodigo.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zup.casadocodigo.dto.ErrorResponseDto;
import br.com.zup.casadocodigo.exception.EntityNotFoundException;

@RestControllerAdvice
public class HandleEntityNotFound {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EntityNotFoundException.class)
	public ErrorResponseDto handle(EntityNotFoundException exception) {
		return new ErrorResponseDto(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
	}
}
