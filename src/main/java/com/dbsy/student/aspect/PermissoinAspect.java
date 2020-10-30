package com.dbsy.student.aspect;

import com.dbsy.student.annotation.Permission;
import com.dbsy.student.pojo.Admin;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

//@Component
//@Aspect
public class PermissoinAspect {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.dbsy.student.annotation.Permission)||@within(com.dbsy.student.annotation.Permission)")
    public Object around(ProceedingJoinPoint pJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        Class<?> aClass = pJoinPoint.getTarget().getClass();
        String name = pJoinPoint.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) pJoinPoint.getSignature()).getParameterTypes();
        Method method = aClass.getMethod(name, parameterTypes);//通过反射获得该方法

        Permission permission = method.getAnnotation(Permission.class);
        Admin admin = (Admin) request.getSession().getAttribute("user");



        return null;
    }
}
