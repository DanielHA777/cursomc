package com.daniel.cursomc.services;


import javax.mail.internet.MimeMessage;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.daniel.cursomc.domain.Pedido;

import ch.qos.logback.classic.Logger;

public class MockEmailService extends AbstractEmailService {

	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email HTML...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
		
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		
		
	}
}