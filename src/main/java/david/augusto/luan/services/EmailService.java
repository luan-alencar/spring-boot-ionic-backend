package david.augusto.luan.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import david.augusto.luan.domain.Cliente;
import david.augusto.luan.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(Pedido obj);

	void sendHtmlEmail(MimeMessage msg);

	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
