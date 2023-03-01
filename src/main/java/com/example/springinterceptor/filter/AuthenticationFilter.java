package com.example.springinterceptor.filter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CustomFilter(order = 20)
public class AuthenticationFilter implements ICustomFilter {
    public void execute(String request) {
        log.info("Authenticating request: " + request);
    }
}
