package Wiprospringframework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* ShoppingService.*(..))")
    public void logBefore() {
        System.out.println("Before method call");
    }

    @AfterReturning(pointcut = "execution(* ShoppingService.*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("After returning: " + result);
    }

    @AfterThrowing(pointcut = "execution(* ShoppingService.*(..))", throwing = "error")
    public void logAfterThrowing(Throwable error) {
        System.out.println("Exception occurred: " + error.getMessage());
    }

    @Around("execution(* ShoppingService.*(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around before");
        Object result = pjp.proceed();
        System.out.println("Around after");
        return result;
    }
}
