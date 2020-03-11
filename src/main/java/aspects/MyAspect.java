package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {
    int counterUsernames=0;
    int counterGmails=0;
    int counterOutlooks=0;
    int counterYahoo=0;
 int longData=0;

    @Before("execution(* io.swagger.model.User.*(..))")
    public void before(JoinPoint joinPoint){

        System.out.print("\nInitiating statistics");

    }

    /**
     * Will log every execution of Users's methods
     */
    @Around("execution(* io.swagger.model.User.*(..))")//pointcut-what kind of methods are to be intercepted
    public Object doThing(final ProceedingJoinPoint thisJoinPoint) throws Throwable {
      //advice=what you want to happen in the logging

        final String joinPointName = thisJoinPoint.getThis().getClass().getSimpleName() + "." + thisJoinPoint.getSignature().getName() + "()";

        System.out.println("\nEntering [" + joinPointName + "]");

        //join point=during runtime,its the execution of the aop that we had defined
        //execution of the loadTimeWeave() is called pointcut for example
        //weaving - its the wiring of pointcut with the method that we need in the pointcut.

        Object retVal = thisJoinPoint.proceed();
        System.out.println("\nLeaving  [" + joinPointName + "]");


        return retVal;

    }
    @After("execution(* io.swagger.model.User.*(..))")
    public void after(JoinPoint joinPoint){

        System.out.println(Arrays.toString(joinPoint.getArgs()));
        if(Arrays.toString(joinPoint.getArgs()).contains("username")){
            counterUsernames++;
        }
        System.out.print("\n The number of possible fake accounts= "+counterUsernames);


        if(Arrays.toString(joinPoint.getArgs()).contains("@gmail")){
            counterGmails++;
        }
        System.out.print("\r\n The number of Gmail users = "+counterGmails);


        if(Arrays.toString(joinPoint.getArgs()).contains("@yahoo")){
            counterYahoo++;
        }
        System.out.print("\n The number of Yahoo = "+counterYahoo);

        if(Arrays.toString(joinPoint.getArgs()).contains("@outlook")){
            counterOutlooks++;
        }
        System.out.print("\n The number of Outlooks = "+counterOutlooks);
        if(Arrays.toString(joinPoint.getArgs()).length()>25){
            longData++;
        }
        System.out.print("\n Users that needs update info, too long data for database "+longData);
    }

    }


