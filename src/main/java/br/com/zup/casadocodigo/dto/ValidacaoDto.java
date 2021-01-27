package br.com.zup.casadocodigo.dto;

public class ValidacaoDto {
	private String campo;
	private String mensagem;
	
	public ValidacaoDto(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
}
