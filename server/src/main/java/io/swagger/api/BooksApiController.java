package io.swagger.api;

import io.swagger.model.Book;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-02-22T09:03:35.781+01:00[Europe/Berlin]")
@Controller
public class BooksApiController implements BooksApi {

    private final BooksApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public BooksApiController(BooksApiDelegate delegate) {
        this.delegate = delegate;
    }
    public ResponseEntity<List<Book>> filterAllBooks() {
        return delegate.filterAllBooks();
    }

}
