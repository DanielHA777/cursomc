package com.daniel.cursomc.domain;

public enum EstadoPagamento {
Pendente(1, "Pendente"),
Quitado(2, "Quitado"),
Cancelado(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(EstadoPagamento x : EstadoPagamento.values()) { // todo obj x nos valores possíveis do tipocliente
			if(cod.equals(x.getCod())) { //se o cod do arhumento for igual ao x.getcod, retorna esse x
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

