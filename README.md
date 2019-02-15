# swagger-bookstore
A demo project using the Swagger toolset to describe my API.

## Swagger API Lifecycle
### Plan
Run Swagger Editor with this command:
```
docker run --name swagger-editor -d -p 8080:8080 swaggerapi/swagger-editor
open http://localhost:8080
```

### Build
Export the OpenAPI Specification (api.yaml) from the Swagger Editor and place it into the folder: `src/main/resources/`


