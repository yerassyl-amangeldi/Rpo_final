package com.example.yerassyl.service;

import com.example.yerassyl.entity.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    void getAllTest() {
        List<Author> authors = authorService.findAll();
        Assertions.assertNotNull(authors);
    }

    @Test
    void getByIdTest() {
        Author newAuthor = Author.builder()
                .firstName("Test")
                .lastName("Author")
                .birthDate(LocalDate.of(1900, 1, 1))
                .nationality("Test")
                .biography("Test bio")
                .build();

        Author created = authorService.save(newAuthor);
        Author found = authorService.findById(created.getId()).orElse(null);

        Assertions.assertNotNull(found);
        Assertions.assertNotNull(found.getId());
        Assertions.assertNotNull(found.getFirstName());
        Assertions.assertNotNull(found.getLastName());
    }

    @Test
    void addTest() {
        Author author = Author.builder()
                .firstName("George")
                .lastName("Orwell")
                .birthDate(LocalDate.of(1903, 6, 25))
                .nationality("British")
                .biography("English novelist")
                .build();

        Author added = authorService.save(author);

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getFirstName());
        Assertions.assertNotNull(added.getLastName());

        Author found = authorService.findById(added.getId()).orElse(null);

        Assertions.assertNotNull(found);
        Assertions.assertEquals(added.getId(), found.getId());
        Assertions.assertEquals(added.getFirstName(), found.getFirstName());
        Assertions.assertEquals(added.getLastName(), found.getLastName());
    }
}