package mz.com.soto.junior.ordem_servico.enuns;

public enum Prioridade {
	
	BAIXA(0, "BAIXA"),
	MEEDIA(1, "MEDIA"),
	ALTA(2, "ALTA");
	
	private Integer cod;
	@SuppressWarnings("unused")
	private String descricao;
	private Prioridade(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	
	public static Prioridade toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for(Prioridade x : Prioridade.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		 throw new IllegalArgumentException("Prioridade Invalida!" + cod);
	}
	
	
}
