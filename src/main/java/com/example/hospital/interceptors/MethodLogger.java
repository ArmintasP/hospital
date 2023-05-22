package com.example.hospital.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class MethodLogger implements Serializable {
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        var paramsCount = context.getParameters().length;

        System.out.println("Called method: " + context.getMethod().getName() + " with " + paramsCount + " parameters.");
        return context.proceed();
    }
}
