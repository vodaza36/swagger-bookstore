# Swagger Bookstore API
In diesem Beispiel wird gezeigt, wie anhand einer beispielhaften OpenAPI Spezifikation, der dazugehörige Server-Code generiert werden kann. Das Repository ist dabei in unterschiedliche Branches gegliedert, welche die angebotenen Möglichkeiten näher untersucht.

## Branch 'third-approach'
Dieser Branch beschäftig sich mit dem Thema "Bean Validation". Dabei wird die Konfiguration des CodeGenerators erweitert, sodass der Server-Teil mit aktiver BeanValidation generiert wird.

## CodeGen Konfig
In der `pom.xml` die Swagger-Maven-Plugin Konfiguration anpassen:
```
...
<useBeanValidation>true</useBeanValidation>
...
```

## Test
- [Swagger-UI](http://localhost:8080/v0/swagger-ui.html)
- Neues Buch hinzufügen:

```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
   "description": "Test Book", 
   "id": 1,
   "name": "MyFirstBook" 
 }' 'http://localhost:8080/v0/books'
```
- Ungültiges Buch hinzufügen:

```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
   "description": "Test Book", 
   "id": 1
 }' 'http://localhost:8080/v0/books'
```