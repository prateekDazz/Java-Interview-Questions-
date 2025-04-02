package com.udemy.RestApi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/api")
public class RateLimitController {
	
	@GetMapping("/resilient")
 @RateLimiter(name = "myLimiter", fallbackMethod = "rateLimitFallback")
    public String resilientEndpoint() {
        return "Request processed successfully!";
    }

    public String rateLimitFallback(Exception e) {
        return "Too Many Requests! Please wait.";
    }

}
