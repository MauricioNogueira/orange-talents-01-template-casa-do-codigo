package br.com.zup.casadocodigo.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.customvalidation.CPFOuCNPJ;
import br.com.zup.casadocodigo.customvalidation.ReferenceEntity;
import br.com.zup.casadocodigo.model.Pais;

public class FechaCompraRequest {

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@CPFOuCNPJ
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ReferenceEntity
	private Long paisId;
	
	private Long estadoId;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;
	
	public FechaCompraRequest(String email, String nome, String sobrenome, String documento, String endereco,
			String complemento, String cidade, Long paisId, Long estadoId, String telefone, String cep) {
		
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "FechaCompraRequest [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", paisId=" + paisId + ", estadoId=" + estadoId + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

	public void toModel() {
		// TODO Auto-generated method stub
	}
}
