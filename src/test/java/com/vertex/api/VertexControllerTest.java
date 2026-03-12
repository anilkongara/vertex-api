package com.vertex.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class VertexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getVertex_returnsOkStatus() throws Exception {
        mockMvc.perform(get("/api/vertex"))
                .andExpect(status().isOk());
    }

    @Test
    void getVertex_returnsJsonContentType() throws Exception {
        mockMvc.perform(get("/api/vertex"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getVertex_returnsExpectedId() throws Exception {
        mockMvc.perform(get("/api/vertex"))
                .andExpect(jsonPath("$.id", is("vtx-001")));
    }

    @Test
    void getVertex_returnsExpectedLabel() throws Exception {
        mockMvc.perform(get("/api/vertex"))
                .andExpect(jsonPath("$.label", is("SampleVertex")));
    }

    @Test
    void getVertex_returnsExpectedType() throws Exception {
        mockMvc.perform(get("/api/vertex"))
                .andExpect(jsonPath("$.type", is("default")));
    }

    @Test
    void getVertex_returnsProperties() throws Exception {
        mockMvc.perform(get("/api/vertex"))
                .andExpect(jsonPath("$.properties.name", is("Vertex A")))
                .andExpect(jsonPath("$.properties.weight", is(1.5)))
                .andExpect(jsonPath("$.properties.active", is(true)));
    }

    @Test
    void getVertex_returnsEdges() throws Exception {
        mockMvc.perform(get("/api/vertex"))
                .andExpect(jsonPath("$.edges", hasSize(3)))
                .andExpect(jsonPath("$.edges[0]", is("edge-101")))
                .andExpect(jsonPath("$.edges[1]", is("edge-102")))
                .andExpect(jsonPath("$.edges[2]", is("edge-103")));
    }

    @Test
    void getVertex_returnsTimestamp() throws Exception {
        mockMvc.perform(get("/api/vertex"))
                .andExpect(jsonPath("$.timestamp", notNullValue()));
    }

    @Test
    void getVertex_takesAtLeastTwoSeconds() throws Exception {
        long start = System.currentTimeMillis();
        mockMvc.perform(get("/api/vertex"))
                .andExpect(status().isOk());
        long elapsed = System.currentTimeMillis() - start;
        assert elapsed >= 2000 : "Expected at least 2 seconds delay, but got " + elapsed + "ms";
    }
}
