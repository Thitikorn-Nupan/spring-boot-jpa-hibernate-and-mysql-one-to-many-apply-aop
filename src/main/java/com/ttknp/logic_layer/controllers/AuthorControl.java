package com.ttknp.logic_layer.controllers;

import com.ttknp.logic_layer.entities.Author;
import com.ttknp.logic_layer.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import java.time.Instant;
@RestController
@RequestMapping(value = "/api/author")
@CrossOrigin(origins = "*", allowedHeaders = "*") // ** way to set allow all cross origins
public class AuthorControl {
    private Logger log = LoggerFactory.getLogger(AuthorControl.class);
    private AuthorService authorService;
    @Autowired
    public AuthorControl(AuthorService authorService) {
        this.authorService = authorService;
    }
    @RequestMapping(value = {"/",""},method = RequestMethod.GET)
    private ResponseEntity checkServer() {
        // log.info("unix timestamp {}",Instant.now().getEpochSecond());
        return ResponseEntity.ok().body("hello world");
    }
    @GetMapping(value = "/reads")
    private ResponseEntity getAllAuthors() {
        return ResponseEntity.ok().body(authorService.getAllAuthors());
    }
    @GetMapping(value = "/read")
    private ResponseEntity getAuthorById(@RequestParam String aid) {
        return ResponseEntity.ok().body(authorService.getAuthorById(aid));
    }
    @PostMapping(value = "/create")
    private ResponseEntity saveAuthor(@RequestBody Author author) {
        log.debug("(saveAuthor) author : {}", author); // (saveAuthor) author : Author{aid='A003', fullname='Don Don', age=43, alive=false}
        return ResponseEntity.ok().body(authorService.saveAuthor(author));
    }
    @DeleteMapping(value = "/delete")
    private ResponseEntity removeAuthor(@RequestParam String aid) {
        return ResponseEntity.ok().body("Can't delete author "+aid+". Cause it has been more than one table");
    }
    @PutMapping(value = "/update")
    private ResponseEntity updateAuthor(@RequestBody Author author, @RequestParam String aid) throws RuntimeException {
        return ResponseEntity.status(202).body(authorService.editAuthor(author, aid));
    }
}
