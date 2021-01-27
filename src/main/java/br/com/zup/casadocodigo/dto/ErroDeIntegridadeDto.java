package br.com.zup.casadocodigo.dto;

public class ErroDeIntegridadeDto {
	
	private String mensagem;
	
	public ErroDeIntegridadeDto(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
}
