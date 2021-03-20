package com.daniel.cursomc.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	//private Calendar dataVencimento;
	//@Temporal(TemporalType.DATE)
	//private Calendar dataPagamento;
	private String dataVencimento;
	private String dataPagamento;


	public PagamentoComBoleto() {
		
	}




	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, String dataVencimento, String dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}




	public String getData() {
		return dataVencimento;
	}

	public void setData(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}



	public String getDataPagamento() {
		return dataPagamento;
	}



	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
