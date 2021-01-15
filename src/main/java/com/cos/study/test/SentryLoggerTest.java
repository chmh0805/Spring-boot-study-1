package com.cos.study.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentryLoggerTest {
	private static final Logger log = LoggerFactory.getLogger(SentryLoggerTest.class);

	  @GetMapping("/test/log")
	  void hello() {
	    log.error("Event triggered by Logback integration");
	    throw new IllegalArgumentException("Event triggered by Spring integration");
	  }
}
