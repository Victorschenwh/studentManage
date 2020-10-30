package com.dbsy.student.aspect;

import com.dbsy.student.pojo.Admin;
import com.dbsy.student.pojo.History;
import com.dbsy.student.service.HistoryService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * LogAspect  用于日志记录
 */

//@Component
//@Aspect
//@Order(1)
public class LogAspect {

    @Autowired
    HistoryService historyService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.dbsy.student.controller.*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint pJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("ARGS: " + Arrays.toString(pJoinPoint.getArgs()) + "\n url: " + request.getRequestURL().toString() + "\n method: " + request.getMethod() + "\n ip: " + request.getRemoteAddr() + "\n ClassName.method: " + pJoinPoint.getSignature().getDeclaringTypeName() + "." + pJoinPoint.getSignature().getName());
        Object o = pJoinPoint.proceed();
        log.info(o.toString());
        historyService.insert(new History(null, request.getRemoteAddr(), ((Admin) (request.getSession().getAttribute("user"))).getId(),
                new Date(), request.getRequestURL().toString(), Arrays.toString(pJoinPoint.getArgs()), o.toString(),
                pJoinPoint.getSignature().getDeclaringTypeName() + "." + pJoinPoint.getSignature().getName()));
        return o;
    }


    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // 记录下请求内容
//        log.info("ARGS: " + Arrays.toString(joinPoint.getArgs()) + "\n url: " + request.getRequestURL().toString() + "\n method: " + request.getMethod() + "\n ip: " + request.getRemoteAddr() + "\n ClassName.method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        //log.info("方法的返回值 : " + ret);
    }

    //后置异常通知
    @AfterThrowing("webLog()")
    public void methodThrows(JoinPoint jp) {
        log.info("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp) {
        //log.info("请求执行完毕......");
    }

}
