package training.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import training.dao.DaoException;

@EnableAspectJAutoProxy
@Component
@Aspect
public class CustomAspect {

	// aspect is made up of 1 or more advice (functions).
	// advice can be - Before, After, AfterThrowing, Around.
	// Advice must have a point-cut expression, using which functions
	// will be intercepted.

	@Before("execution(* training..ProductDao.*(..))")
	public void log(JoinPoint jp) {
		Signature sig = jp.getSignature();

		System.out.println();
		System.out.println("function intercepted is: " + sig.getName());
		System.out.println("declared in " + sig.getDeclaringTypeName());
		System.out.println("Arguments to the funciton: " + Arrays.toString(jp.getArgs()));
		System.out.println("Target object is of type: " + jp.getTarget().getClass());

	}

	@AfterThrowing(pointcut = "execution(* training..ProductDao.*(..))", throwing = "t")
	public void convertToDaoException(Throwable t) throws DaoException {
		throw new DaoException(t);
	}

}
