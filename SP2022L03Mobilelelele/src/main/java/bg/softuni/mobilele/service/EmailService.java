/**
 * @author dimitar
 *
 */
package bg.softuni.mobilele.service;

import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
	
	private final TemplateEngine templateEngine;
	private final JavaMailSender javaMailSender;
	private final MessageSource messageSource;

	public EmailService(TemplateEngine templateEngine, MessageSource messageSource, JavaMailSender javaMailSender) {
		this.templateEngine = templateEngine;
		this.messageSource = messageSource;
		this.javaMailSender = javaMailSender; 
	}
	
	public void sendRegistrationEmail(
			String userEmail,
			String username,
			Locale preferredLocale
			) {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			mimeMessageHelper.setFrom("mobilele@mobilele.com");
			mimeMessageHelper.setTo(userEmail);
			mimeMessageHelper.setSubject(getEmailSubject(preferredLocale));  
			mimeMessageHelper.setText(generateMessageContent(preferredLocale,username),true);
			
			javaMailSender.send(mimeMessageHelper.getMimeMessage()); 
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
		
	}
	
	private String getEmailSubject(Locale locale) {
		return messageSource.getMessage("registration_subject", new Object[0],locale);
		
	}
	
	private String generateMessageContent(Locale locale, String username) {
		
		Context ctx = new Context();
		ctx.setLocale(locale);
		ctx.setVariable("userName", username);
		return templateEngine.process("email/registration", ctx);
		
	}

}
