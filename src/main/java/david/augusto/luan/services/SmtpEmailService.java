package david.augusto.luan.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import david.augusto.luan.domain.Pedido;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SmtpEmailService extends AbstractEmailService{

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	private MailSender mailSender;
	
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email");
		mailSender.send(msg);
		LOG.info("Email enviado!");
	}


	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email HTML");
		javaMailSender.send(msg);
		LOG.info("Email enviado!");
	}


	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		
	}
	
	
}
