package david.augusto.luan.services;

import org.springframework.mail.SimpleMailMessage;

import david.augusto.luan.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido p);
	
	void sendEmail(SimpleMailMessage msg);
}
