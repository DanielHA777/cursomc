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
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository2 cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecorepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama, mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletronicos");
		Categoria cat5 = new Categoria(null, "Jardim");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "Mouser", 80.00);
		Produto p3 = new Produto(null, "Impressora", 200.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3)); // categoria 1 associado a os 3 produtos
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria", "maria@123.com", "11111111", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("20202020", "999999"));
		Endereco e1 = new Endereco(null, "rua Flores", "300", "apto 303", "jandira", "33333333", cli1, c1);
		Endereco e2 = new Endereco(null, "rua teste", "300", "apto 403", "centro", "33333333", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecorepository.saveAll(Arrays.asList(e1, e2));

		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, "20/03/2021", cli1, e1);
		Pedido ped2 = new Pedido(null, "19/03/2021 00:00", cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.Quitado, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.Pendente, ped2, "20/03/2021", "");
		ped2.setPagamento(pagto2);
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
	
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
	    pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	
	    ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2.000);
	    ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 1, 80.00);
	    ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 200.00);
	
	    ped1.getItens().addAll(Arrays.asList(ip1, ip2));
	    
	    p1.getItens().addAll(Arrays.asList(ip1));
	    p2.getItens().addAll(Arrays.asList(ip3));
	    p3.getItens().addAll(Arrays.asList(ip2));
	
	    itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
