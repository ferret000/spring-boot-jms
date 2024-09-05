package sample.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import jakarta.jms.ConnectionFactory;

@EnableJms
@SpringBootApplication
public class Application {

	public final static String PRODUCT_MESSAGE_QUEUE = "product-message-queue";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory  connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}
}
