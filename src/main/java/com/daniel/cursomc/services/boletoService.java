package com.daniel.cursomc.services;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.PagamentoComBoleto;

@Service
public class boletoService {

	public static void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}