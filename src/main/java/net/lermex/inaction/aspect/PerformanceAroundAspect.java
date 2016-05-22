package net.lermex.inaction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAroundAspect {

    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(PerformanceAroundAspect.class);

    @Around("execution(* net.lermex.inaction.model.entity.Statistics.generateStatistic())")
    public Object statisticAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        long startTime = System.currentTimeMillis();
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long workingTime = System.currentTimeMillis() - startTime;
        LOG.info("WorkingTime (ms): " + workingTime);
        return value;
    }
}