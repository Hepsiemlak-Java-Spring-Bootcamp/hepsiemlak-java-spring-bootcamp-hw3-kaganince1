package emlakburada.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class ActiveMqConfig {
	/*@Value("${activemq.broker.url}")
	private String brokerUrl;*/

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("emlakburada-activemq-queue");
	}

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		  connectionFactory.setBrokerURL("tcp://hostname:61616");
		  connectionFactory.setUserName("admin");
		  connectionFactory.setPassword("admin");
		  return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
