package emlakburada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import emlakburada.dto.EmailMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ActiveMqListenerService {
	@Autowired
	private EmailService emailService;
	
	@JmsListener(destination = "emlakburada-activemq-queue")
	public void consumeMessage(EmailMessage message) {
		log.info(message.toString());
		emailService.send(message.getEmail());
	}
}
