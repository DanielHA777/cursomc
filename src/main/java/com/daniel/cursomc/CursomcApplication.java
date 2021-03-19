package com.daniel.cursomc;

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
import com.daniel.cursomc.domain.Produto;
import com.daniel.cursomc.domain.TipoCliente;
import com.daniel.cursomc.repository.CategoriaRepository;
import com.daniel.cursomc.repository.CidadeRepository2;
import com.daniel.cursomc.repository.ClienteRepository;
import com.daniel.cursomc.repository.EnderecoRepository;
import com.daniel.cursomc.repository.EstadoRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "Mouser", 80.00);
		Produto p3 = new Produto(null, "Impressora", 200.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3)); // categoria 1 associado a os 3 produtos
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	
	    Cliente cli1 = new Cliente(null, "Maria Slva", "maria@123.com","11111111111", TipoCliente.PESSOAFISICA);
	    cli1.getTelefones().addAll(Arrays.asList("20202020", "999999999"));
	    Endereco e1 = new Endereco(null, "rua Flores", "300", "apto 303", "jandira", "33333333", cli1, c1 );
	    Endereco e2 = new Endereco(null, "rua teste", "300", "apto 403", "centro", "33333333", cli1, c2 );
	    cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
	    clienteRepository.saveAll(Arrays.asList(cli1));
	    enderecorepository.saveAll(Arrays.asList(e1,e2));
	
	}
}
