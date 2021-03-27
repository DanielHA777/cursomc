package com.daniel.cursomc;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.domain.Cidade;
import com.daniel.cursomc.domain.Cliente;
import com.daniel.cursomc.domain.Endereco;
import com.daniel.cursomc.domain.Estado;
import com.daniel.cursomc.domain.EstadoPagamento;
import com.daniel.cursomc.domain.ItemPedido;
import com.daniel.cursomc.domain.Pagamento;
import com.daniel.cursomc.domain.PagamentoComBoleto;
import com.daniel.cursomc.domain.PagamentoComCartao;
import com.daniel.cursomc.domain.Pedido;
import com.daniel.cursomc.domain.Produto;
import com.daniel.cursomc.domain.TipoCliente;
import com.daniel.cursomc.repository.CategoriaRepository;
import com.daniel.cursomc.repository.CidadeRepository2;
import com.daniel.cursomc.repository.ClienteRepository;
import com.daniel.cursomc.repository.EnderecoRepository;
import com.daniel.cursomc.repository.EstadoRepository;
import com.daniel.cursomc.repository.ItemPedidoRepository;
import com.daniel.cursomc.repository.PagamentoRepository;
import com.daniel.cursomc.repository.PedidoRepository;
import com.daniel.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
	}	
}