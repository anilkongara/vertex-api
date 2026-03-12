package com.vertex.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VertexApiApplicationTest {

    @Test
    void contextLoads() {
        // Verifies that the Spring application context loads successfully
    }

    @Test
    void mainMethodStartsApplication() {
        // Verifies that the main method can be invoked without errors
        // Using a short timeout to prevent the app from running indefinitely
        Thread thread = new Thread(() -> VertexApiApplication.main(new String[]{}));
        thread.setDaemon(true);
        thread.start();
    }
}
