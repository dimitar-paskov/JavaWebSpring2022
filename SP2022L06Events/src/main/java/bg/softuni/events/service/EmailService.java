/**
 * @author dimitar
 *
 */
package bg.softuni.events.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import bg.softuni.events.event.OrderCreatedEvent;

@Service
public class EmailService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
	
	@Order(1)
	@EventListener
	public void onOrderCreated(OrderCreatedEvent evt) {
		
		LOGGER.info("Sending email to user for order {}", evt.getOrderId() );
		
	}

}
