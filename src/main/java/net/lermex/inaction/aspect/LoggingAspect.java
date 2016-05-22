package net.lermex.inaction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* net.lermex.inaction.model.entity.Statistics.generateStatistic())")
    public void log(JoinPoint joinPoint){
        LOG.info(joinPoint.getSignature().getName());
    }

}
