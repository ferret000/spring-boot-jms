package sample.jms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

	private static final Logger log = LogManager.getLogger(MessageListener.class);

	@JmsListener(destination = Application.PRODUCT_MESSAGE_QUEUE, containerFactory = "jmsFactory")
	public void receiveMessage(String message) {
		log.info("Received <" + message + ">");
		log.info("Message processed...");
	}
}
