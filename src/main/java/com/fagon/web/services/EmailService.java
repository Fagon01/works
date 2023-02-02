package com.fagon.web.services;

import org.springframework.mail.SimpleMailMessage;

import com.fagon.web.entities.Cliente;
import com.fagon.web.entities.Pedido;

import jakarta.mail.internet.MimeMessage;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Cliente empresa, String newPass);
	
}
