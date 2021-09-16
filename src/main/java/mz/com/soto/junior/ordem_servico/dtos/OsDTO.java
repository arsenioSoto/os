package mz.com.soto.junior.ordem_servico.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import mz.com.soto.junior.ordem_servico.domain.Os;

public class OsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	
	private Integer prioridade;
	private Integer status;
	
	@NotEmpty(message = "Campo Observacao e Requerido!")
	private String observacao;
	
	@NotEmpty(message = "Campo Produto e Requerido!")
	private String produto;
	
	@NotEmpty(message = "Campo Descricao e Requerido!")
	private String descricaoProduto;
	
	private double valor;
	private Integer tecnico;
	private Integer cliente;
	
	
	public OsDTO() {
		super();
		
	}


	public OsDTO(Os obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCod();
		this.status = obj.getStatus().getCod();
		this.observacao = obj.getObservacao();
		this.produto = obj.getProduto();
		this.descricaoProduto = obj.getDescricaoProduto();
		this.valor = obj.getValor();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public Integer getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}


	public String getDescricaoProduto() {
		return descricaoProduto;
	}


	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public Integer getTecnico() {
		return tecnico;
	}


	public void setTecnico(Integer tecnico) {
		this.tecnico = tecnico;
	}


	public Integer getCliente() {
		return cliente;
	}


	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	

}
