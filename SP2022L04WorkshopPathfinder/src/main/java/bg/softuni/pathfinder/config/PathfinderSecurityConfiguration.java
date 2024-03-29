/**
 * @author dimitar
 *
 */
package bg.softuni.pathfinder.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class PathfinderSecurityConfiguration {
	
	 @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new Pbkdf2PasswordEncoder();
	  }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
		.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
		.antMatchers("/", "/routes/**", "/api/**").permitAll()
		.antMatchers("/users/login", "/users/register").anonymous()
		.antMatchers("/users/profile").authenticated()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/users/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.defaultSuccessUrl("/")
		.failureForwardUrl("/users/login?error=true")
		.and()
		.logout()
		.logoutUrl("/users/logout")
		.clearAuthentication(true)
		.deleteCookies("JSESSIONID")
		.logoutSuccessUrl("/");	
//		.and()
//		.csrf().disable();
		
		return http.build();
		
		
	}

}
