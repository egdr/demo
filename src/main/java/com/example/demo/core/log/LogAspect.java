package com.example.demo.core.log;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public * com.example.demo.*.controller..*.*(..))")
    public void aspectPoint(){

    }

    @Before("aspectPoint()")
    public void LogRequestInfo(JoinPoint joinPoint){
        // 执行controller 方法之前需要记录的请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request;
        if (attributes != null) {
            request = attributes.getRequest();
            log.info("URL: {}",request.getRequestURL());
            log.info("HTTP_METHOD: {} ", request.getMethod());
            log.info("IP: {}", request.getRemoteAddr());
            log.info("CLASS_METHOD: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            log.info("ARGS: {}", JSONArray.toJSONString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(returning = "result", pointcut = "aspectPoint()")
    public void LogResponseInfo(Object result){
        log.info("RESULT: {}", JSONArray.toJSONString(result));
    }

    @Around("aspectPoint()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        log.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }

}
