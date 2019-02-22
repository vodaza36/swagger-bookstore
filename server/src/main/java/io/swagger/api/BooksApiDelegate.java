package io.swagger.api;

import io.swagger.model.Book;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * A delegate to be called by the {@link BooksApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-02-22T09:03:35.781+01:00[Europe/Berlin]")
public interface BooksApiDelegate {

    /**
     * @see BooksApi#filterAllBooks
     */
    ResponseEntity<List<Book>> filterAllBooks();

}
