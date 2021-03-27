package com.daniel.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.daniel.cursomc.services.DBService;
import com.sun.el.parser.ParseException;

@Configuration
@Profile("Dev") // configuração especifica do profile, todos beans dentro dessa classe é ativados quando o profile text estivr ativo 
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")// pegando o valor da chave, se for diferente de create n faz nada
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException, java.text.ParseException {
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		return true;
	}
	
	/*@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}*/
}