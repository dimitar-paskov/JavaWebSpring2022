/**
 * @author dimitar
 *
 */
package bg.softuni.mobilele.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
	
	private final TemplateEngine templateEngine;
	private final JavaMailSender javaMailSender;

	public EmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
		this.templateEngine = templateEngine;
		this.javaMailSender = javaMailSender;
	}
	
	public void sendRegistrationEmail(
			String userEmail,
			String username
			) {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			mimeMessageHelper.setFrom("mobilele@mobilele.com");
			mimeMessageHelper.setTo(userEmail);
			mimeMessageHelper.setSubject("Welcom to Mobilele!"); 
			mimeMessageHelper.setText(generateMessageContent(username),true);
			
			javaMailSender.send(mimeMessageHelper.getMimeMessage()); 
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	private String generateMessageContent(String username) {
		
		Context ctx = new Context();
		ctx.setVariable("userName", username);
		return templateEngine.process("email/registration", ctx);
		
	}

}
