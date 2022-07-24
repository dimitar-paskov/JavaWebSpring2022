/**
 * @author dimitar
 *
 */
package bg.softuni.aop.sample2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import bg.softuni.aop.IncredibleMachine;

@Component
@ConditionalOnProperty(
		value = "sample2.enabled", 
		havingValue = "true"
)
public class Sample2AspectDemo implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	private final IncredibleMachine incredibleMachine; 

	public Sample2AspectDemo(IncredibleMachine incredibleMachine) {
		this.incredibleMachine = incredibleMachine;
		
	}
	
	@Override
	public void run(String... args) throws Exception {
				
		LOGGER.info(incredibleMachine.concat("Hello ", "world")); 
	}
	
	

}
