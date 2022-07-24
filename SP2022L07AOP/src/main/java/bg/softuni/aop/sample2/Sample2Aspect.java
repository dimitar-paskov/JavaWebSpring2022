/**
 * @author dimitar
 *
 */
package bg.softuni.aop.sample2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty(
		value = "sample2.enabled", 
		havingValue = "true"
)
public class Sample2Aspect {
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(* bg.softuni.aop.IncredibleMachine.concat(..))")
	void onConcat() {}
	
	
	@Around(value = "onConcat() && args(a, b)")
	public String onConcat(ProceedingJoinPoint pjp, String a, String b) throws Throwable {
		
		//Before the execution of concat
		LOGGER.info("The onConcat method was called with arguments [{}] and [{}].",a,b);
		
		var modifiedA = "(" + a + ")"; 
		var modifiedB = "(" + b + ")"; 
		
		//execute the method
		var result = pjp.proceed(new Object[]{modifiedA, modifiedB}); 
		
		//modify the result
		return "[" + result + "]";
		
	}

}
