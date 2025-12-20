package com.example.yerassyl.controller;

import com.example.yerassyl.dto.BookDto;
import com.example.yerassyl.entity.Book;
import com.example.yerassyl.mapper.BookMapper;
import com.example.yerassyl.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(bookMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> searchByTitle(@RequestParam String title) {
        List<BookDto> books = bookService.searchByTitle(title)
                .stream()
                .map(bookMapper::toDto)
                .toList();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookDto> getBookByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn)
                .map(bookMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        Book savedBook = bookService.save(bookMapper.toEntity(bookDto));
        BookDto savedDto = bookMapper.toDto(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        Book updatedBook = bookService.update(id, bookMapper.toEntity(bookDto));
        BookDto updatedDto = bookMapper.toDto(updatedBook);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}