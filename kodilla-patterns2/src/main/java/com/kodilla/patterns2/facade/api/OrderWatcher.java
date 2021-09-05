package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);


    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logProcessOrder() {
        LOGGER.info("Invocation of:  processOrder() Method");

    }
}
