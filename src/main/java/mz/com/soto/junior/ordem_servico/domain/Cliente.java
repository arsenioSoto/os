package mz.com.soto.junior.ordem_servico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "cliente")
	private List<Os> list = new ArrayList<>();
		
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String bi, String telefone) {
		super(id, nome, bi, telefone);
	}

	public List<Os> getList() {
		return list;
	}

	public void setList(List<Os> list) {
		this.list = list;
	}
	

}
