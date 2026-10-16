package br.com.natancunha.java_api;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        return Map.of(
            "message", "Minha primeira API REST com Spring Boot!",
            "developer", "Natan Cunha",
            "status", "online"
        );
    }
}
