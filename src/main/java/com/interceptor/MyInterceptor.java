package com.interceptor;

import io.quarkus.logging.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.annotation.Annotation;

@Interceptor
@Cache
public class MyInterceptor {
    @AroundInvoke
    Object execute(InvocationContext context) throws Exception {
        Log.info("------before----------");
        Object proceed = context.proceed();
        Annotation[] annotations = context.getMethod().getAnnotations();
        System.out.println(annotations.length);
        Cache annotation = context.getMethod().getAnnotation(Cache.class);
        System.out.println(annotation.val());
        System.out.println(annotation.key());
        Log.info("------------end---------");
        return proceed;
    }

}
