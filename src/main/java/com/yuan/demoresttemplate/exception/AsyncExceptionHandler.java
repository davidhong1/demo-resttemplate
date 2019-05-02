package com.yuan.demoresttemplate.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @author David Hong
 * @version 1.0
 * @description
 */
@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error("TAG=AsyncException, msg={}, method={}, params={}", ex.getMessage(), method.getName(), params);
    }

}
