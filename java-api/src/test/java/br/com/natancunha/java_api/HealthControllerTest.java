package br.com.natancunha.java_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class HealthControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnHealthyStatus() {
        ResponseEntity<String> response =
            restTemplate.getForEntity("/api/health", String.class);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().contains("\"status\":\"UP\""));
        assertTrue(response.getBody().contains("\"service\":\"java-api\""));
    }
}
