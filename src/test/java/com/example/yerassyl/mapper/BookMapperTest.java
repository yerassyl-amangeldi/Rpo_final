package com.example.yerassyl.mapper;

import com.example.yerassyl.dto.BookDto;
import com.example.yerassyl.entity.Author;
import com.example.yerassyl.entity.Book;
import com.example.yerassyl.entity.Publisher;
import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void convertEntityToDtoTest() {
        Publisher publisher = Publisher.builder()
                .id(1L)
                .name("Penguin Random House")
                .build();

        Author author = Author.builder()
                .id(1L)
                .firstName("George")
                .lastName("Orwell")
                .build();

        Set<Author> authors = new HashSet<>();
        authors.add(author);

        Book book = Book.builder()
                .id(1L)
                .title("1984")
                .isbn("978-0451524935")
                .publicationDate(LocalDate.of(1949, 6, 8))
                .pages(328)
                .language("English")
                .description("Dystopian novel")
                .publisher(publisher)
                .authors(authors)
                .build();

        BookDto bookDto = bookMapper.toDto(book);

        Assertions.assertNotNull(bookDto);
        Assertions.assertNotNull(bookDto.getId());
        Assertions.assertNotNull(bookDto.getTitle());
        Assertions.assertNotNull(bookDto.getIsbn());
        Assertions.assertNotNull(bookDto.getPublisherId());
        Assertions.assertNotNull(bookDto.getPublisherName());

        Assertions.assertEquals(book.getId(), bookDto.getId());
        Assertions.assertEquals(book.getTitle(), bookDto.getTitle());
        Assertions.assertEquals(book.getIsbn(), bookDto.getIsbn());
        Assertions.assertEquals(book.getPublisher().getId(), bookDto.getPublisherId());
        Assertions.assertEquals(book.getPublisher().getName(), bookDto.getPublisherName());
        Assertions.assertTrue(bookDto.getAuthorIds().contains(1L));
    }

    @Test
    void convertDtoToEntityTest() {
        BookDto bookDto = BookDto.builder()
                .id(2L)
                .title("Animal Farm")
                .isbn("978-0451526342")
                .publicationDate(LocalDate.of(1945, 8, 17))
                .pages(112)
                .language("English")
                .description("Allegorical novella")
                .build();

        Book book = bookMapper.toEntity(bookDto);

        Assertions.assertNotNull(book);
        Assertions.assertNotNull(book.getId());
        Assertions.assertNotNull(book.getTitle());
        Assertions.assertNotNull(book.getIsbn());

        Assertions.assertEquals(bookDto.getId(), book.getId());
        Assertions.assertEquals(bookDto.getTitle(), book.getTitle());
        Assertions.assertEquals(bookDto.getIsbn(), book.getIsbn());
        Assertions.assertEquals(bookDto.getPages(), book.getPages());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Book> books = new ArrayList<>();

        books.add(Book.builder()
                .id(1L)
                .title("1984")
                .isbn("978-0451524935")
                .pages(328)
                .authors(new HashSet<>())
                .build());

        books.add(Book.builder()
                .id(2L)
                .title("Animal Farm")
                .isbn("978-0451526342")
                .pages(112)
                .authors(new HashSet<>())
                .build());

        List<BookDto> booksDto = bookMapper.toDtoList(books);

        Assertions.assertNotNull(booksDto);
        Assertions.assertNotEquals(0, booksDto.size());
        Assertions.assertEquals(books.size(), booksDto.size());

        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            BookDto bookDto = booksDto.get(i);

            Assertions.assertNotNull(bookDto);
            Assertions.assertEquals(book.getId(), bookDto.getId());
            Assertions.assertEquals(book.getTitle(), bookDto.getTitle());
        }
    }
}