/**
 * @author dimitar
 *
 */
package bg.softuni.errorhandling.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ErrorConfig {
	
	@Bean
	SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		
		Properties excMapping = new Properties();
		excMapping.put(NullPointerException.class.getSimpleName(), "npe");
		
		resolver.setExceptionMappings(excMapping );
		
		return resolver;
		
	}

}
