# Vertex API

A simple Spring Boot REST API that provides a vertex GET endpoint.

## Endpoint

### GET `/api/vertex`

Returns a sample vertex response after a 2-second delay.

**Sample Response:**
```json
{
  "id": "vtx-001",
  "label": "SampleVertex",
  "type": "default",
  "properties": {
    "name": "Vertex A",
    "weight": 1.5,
    "active": true
  },
  "edges": ["edge-101", "edge-102", "edge-103"],
  "timestamp": "2026-03-12T04:00:00Z"
}
```

## Build & Run

```bash
mvn clean package
java -jar target/vertex-api-0.0.1-SNAPSHOT.jar
```

The API will be available at `http://localhost:8080/api/vertex`.
