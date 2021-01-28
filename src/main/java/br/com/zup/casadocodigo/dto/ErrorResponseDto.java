package br.com.zup.casadocodigo.dto;

public class ErrorResponseDto {
	private String mensagem;
	private int status;
	
	public ErrorResponseDto(String mensagem, int status) {
		this.mensagem = mensagem;
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public int getStatus() {
		return status;
	}
}