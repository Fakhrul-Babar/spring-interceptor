package com.example.springinterceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path = "ping")
public class PingController {

    private final HttpServletRequest request;

    public PingController(HttpServletRequest request) {
        this.request = request;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> ping() {
        Map<String, Object> pingResponse = new HashMap<>();

        pingResponse.put("RequestFrom", request.getRemoteHost());
        pingResponse.put("RequestUser", request.getRemoteUser());
        pingResponse.put("Time", LocalDateTime.now());

        log.info("Ping info: {}", pingResponse);
        return ResponseEntity.ok(pingResponse);
    }

}
