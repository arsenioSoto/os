package mz.com.soto.junior.ordem_servico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<Os> list = new ArrayList<>();
	
	public Tecnico() {
		super();
		
	}

	public Tecnico(Integer id, String nome, String bi, String telefone) {
		super(id, nome, bi, telefone);
		
	}

	public List<Os> getList() {
		return list;
	}

	public void setList(List<Os> list) {
		this.list = list;
	}
	
	
}
