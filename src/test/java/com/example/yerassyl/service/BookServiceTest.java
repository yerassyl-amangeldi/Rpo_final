package com.example.yerassyl.service;

import com.example.yerassyl.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void getAllTest() {
        List<Book> books = bookService.findAll();
        Assertions.assertNotNull(books);
    }

    @Test
    void getByIdTest() {
        Book newBook = Book.builder()
                .title("Test Book")
                .isbn("978-124567890")
                .pages(200)
                .language("English")
                .build();

        Book created = bookService.save(newBook);
        Book found = bookService.findById(created.getId()).orElse(null);

        Assertions.assertNotNull(found);
        Assertions.assertNotNull(found.getId());
        Assertions.assertNotNull(found.getTitle());
    }

    @Test
    void addTest() {
        Book book = Book.builder()
                .title("1984")
                .isbn("978- 45152435")
                .publicationDate(LocalDate.of(1949, 6, 8))
                .pages(328)
                .language("English")
                .description("Dystopian novel")
                .build();

        Book added = bookService.save(book);

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getTitle());

        Book found = bookService.findById(added.getId()).orElse(null);

        Assertions.assertNotNull(found);
        Assertions.assertEquals(added.getId(), found.getId());
        Assertions.assertEquals(added.getTitle(), found.getTitle());
    }
}