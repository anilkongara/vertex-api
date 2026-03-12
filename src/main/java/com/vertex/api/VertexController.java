package com.vertex.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VertexController {

    @GetMapping("/vertex")
    public ResponseEntity<Map<String, Object>> getVertex() throws InterruptedException {
        // Wait for 2 seconds before responding
        Thread.sleep(2000);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("id", "vtx-001");
        response.put("label", "SampleVertex");
        response.put("type", "default");

        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("name", "Vertex A");
        properties.put("weight", 1.5);
        properties.put("active", true);
        response.put("properties", properties);

        response.put("edges", List.of("edge-101", "edge-102", "edge-103"));
        response.put("timestamp", Instant.now().toString());

        return ResponseEntity.ok(response);
    }
}
