package com.huang.left;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories(basePackages = "com.huang.left.repository")
class LeftApplicationTests {

    @Test
    void contextLoads() {
    }

}
