/**
 * @author dimitar
 *
 */
package bg.softuni.intro.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {
	
//	@Primary
	@Bean
//	@Bean("cat")
	public Animal cat() {
		
		return new Cat();
	}
	
	@Bean("normalDog")
	public Animal dog() {
		
		return new Dog();
	}
	
//	@Bean("superDog") // by default it takes the name of the method
	@Bean("mySuperDog")
	public Animal superDog() {
		
		//TODO: add super power to this Dog
		
		return new Dog(true);
	}

}
