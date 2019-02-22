# Swagger Bookstore API
In diesem Beispiel wird gezeigt, wie anhand einer beispielhaften OpenAPI Spezifikation, der dazugehörige Server-Code generiert werden kann. Das Repository ist dabei in unterschiedliche Branches gegliedert, welche die angebotenen Möglichkeiten näher untersucht.

## Branch 'first-approach'
Der Branch 'first-approach' beschreibt den folgenden Ansatz:
- Mittels Swagger-Editor wird die API-Spezifikation (Version: Swagger-2.0) erzeugt.
- Anhand der Spezifikation (api.yml) und der Swagger-Codegen-CLI wird der Code generiert.
- Zuvor wird eine JSON Config Datei erzeugt, welche den CodeGen konfiguriert.
- CodeGen wird ausgeführt, um ein Java Spring Implementierung zu erzeugen
- Der Code wird um die spezifische Service Implementierung erweitert
- Anschließend wird der Spring-Service gestartet
- Ein CURL Request wird abgesetzt

## API Spezifikation
```
swagger: "2.0"
info:
  title: "Bookstore API"
  description: "A bookstore API project"
  termsOfService: "Demo"
  contact:
    name: "Thomas Hochbichler"
    url: "http://hochbichler.at/bookstore"
    email: "thomas@hochbichler.at"
  version: "0.0.1"
host: "localhost:8080"
basePath: "/v0"
schemes:
 - http
paths:
  /books:
    get:
      operationId: "filterAllBooks"
      description: "Returns all books"
      produces:
        - application/json
      responses:
        '200':
          description: "Returns a list of books"
          schema:
            type: array
            items:
              $ref: '#/definitions/Book'
definitions:
  Book:
    type: object
    properties:
      id:
        type: integer
        format: int64
      name:
        type: string
```

## Server-Code generieren
Die JSON-Konfiguration für der Code-Generator erzeugen und als JSON Datei 'config.json' parallel zur API-Spezifikation (api.yml) speichern:
```
{
  "delegatePattern": true
}
```
Im Anschluss die CodeGen CLI starten:
```
swagger-codegen generate -i api.yaml -l spring -o ./server -c ./config.json
```

## Service Implementierung
Im Maven Source das Package 'io.swagger.service' anlegen und darin die Service Implementierung speichern.
```java
package io.swagger.service;

import io.swagger.api.BooksApiDelegate;
import io.swagger.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksApiService implements BooksApiDelegate {

    @Override
    public ResponseEntity<List<Book>> filterAllBooks() {
        Book book = new Book();
        book.setId(100L);
        book.setName("Test Book");
        List<Book> books = new ArrayList<>();
        books.add(book);
        ResponseEntity<List<Book>> result = new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        return result;
    }
}
```

## Test
Den Spring Server wie folgt starten:
```
mvn spring-boot:run
```

Folgenden GET Request mittels cURL an den Server schicken:
```
curl -X GET "http://localhost:8080/v0/books" -H "accept: application/json"
```
