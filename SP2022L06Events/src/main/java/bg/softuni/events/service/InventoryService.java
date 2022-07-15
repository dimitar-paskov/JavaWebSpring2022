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
public class InventoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);
	
	@Order(2)
	@EventListener
	public void onOrderCreated(OrderCreatedEvent evt) {
		
		LOGGER.info("Decreasing inventory for order {}", evt.getOrderId() );
		
	}

}
