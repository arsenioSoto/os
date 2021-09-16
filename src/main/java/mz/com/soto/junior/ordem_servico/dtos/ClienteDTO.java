package mz.com.soto.junior.ordem_servico.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import mz.com.soto.junior.ordem_servico.domain.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "O campo nome e Requerido!")
	private String nome;
	
	@NotEmpty(message = "O campo Bi e Requerido!")
	private String bi;
	
	@NotEmpty(message = "O campo Telefone e Requerido!")
	private String telefone;

	public ClienteDTO() {
		super();

	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.bi = obj.getBi();
		this.telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
