/**
 * @author dimitar
 *
 */
package bg.softuni.pathfinder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import bg.softuni.pathfinder.interceptors.IpBlackListInterceptor;

@Configuration
public class InterceptorConfigurator implements WebMvcConfigurer {
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
//		registry.addInterceptor(new LoggingInterceptor());
		registry.addInterceptor(new IpBlackListInterceptor());
	}

}
