package com.example.springinterceptor.filter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CustomFilter(order = 10)
public class DebugFilter implements ICustomFilter {
    public void execute(String request) {
        log.info("request log: " + request);
    }
}
