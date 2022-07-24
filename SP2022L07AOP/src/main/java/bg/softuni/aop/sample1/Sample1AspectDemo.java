/**
 * @author dimitar
 *
 */
package bg.softuni.aop.sample1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import bg.softuni.aop.IncredibleMachine;

@Component
@ConditionalOnProperty(
		value = "sample1.enabled", 
		havingValue = "true"
)
public class Sample1AspectDemo implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	private final IncredibleMachine incredibleMachine; 

	public Sample1AspectDemo(IncredibleMachine incredibleMachine) {
		this.incredibleMachine = incredibleMachine;
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		incredibleMachine.saySomething();
		incredibleMachine.echo("AOP !!!"); 
		
		try {
		incredibleMachine.boom();
		}catch (Exception e) { 
			LOGGER.info("Exception from boom called"); 
		}
		
		LOGGER.info(incredibleMachine.concat("Hello ", "world")); 
	}
	
	

}
