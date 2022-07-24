/**
 * @author dimitar
 *
 */
package bg.softuni.aop.sample1;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty(
		value = "sample1.enabled", 
		havingValue = "true"
)
public class Sample1Aspect {
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(* bg.softuni.aop.IncredibleMachine.*(..))")
	void onAllIncredibleMachineMethods() {}
	
	@Pointcut("execution(* bg.softuni.aop.IncredibleMachine.echo(..))")
	void onEchoCalled() {}
	
	@AfterThrowing(pointcut = "execution(* bg.softuni.aop.IncredibleMachine.boom())"
			, throwing = "error")
	public void afterThrowing(JoinPoint joinPoint, Throwable error) {
		LOGGER.error("Ups, I think that the method {} threw an Exception and the exception is ... "
				,joinPoint.getSignature()
				,error);
	}
	
	@Before("onAllIncredibleMachineMethods()")
	public void beforeEachMethod(JoinPoint joinPoint) {
		
		LOGGER.info("Before calling method {} with arguments {}",
				joinPoint.getSignature(),
				Arrays.asList(joinPoint.getArgs()));
		
	}

}
