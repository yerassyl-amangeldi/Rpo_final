package com.example.yerassyl.service;

import com.example.yerassyl.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByIdWithAuthors(Long id);

    Optional<Book> findByIsbn(String isbn);

    List<Book> searchByTitle(String title);

    Book save(Book book);

    Book update(Long id, Book book);

    void deleteById(Long id);
}