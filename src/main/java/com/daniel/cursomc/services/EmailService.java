package com.daniel.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.daniel.cursomc.domain.Cliente;
import com.daniel.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	 void sendEmail(SimpleMailMessage msg);
	
	 
	 void sendHtmlEmail(MimeMessage msg);
	
	 void sendNewPasswordEmail(Cliente cliente, String newPass);

	void sendOrderConfirmationHtmlEmail(Pedido obj);
}