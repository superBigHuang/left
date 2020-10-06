package com.huang.left;

public class Log4jTest {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Log4jTest.class);

    public static void main(String... args) {
        log.error("Something else is wrong here");
    }
}
