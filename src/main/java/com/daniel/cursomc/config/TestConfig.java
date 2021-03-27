package com.daniel.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.daniel.cursomc.services.DBService;
import com.sun.el.parser.ParseException;

@Configuration
@Profile("test") // configuração especifica do profile, todos beans dentro dessa classe é ativados quando o profile text estivr ativo 
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException, java.text.ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
	/*@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}*/
}