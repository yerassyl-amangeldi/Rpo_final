package com.example.yerassyl.service;

import com.example.yerassyl.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Author save(Author author);

    Author update(Long id, Author author);

    void deleteById(Long id);

    List<Author> findByLastName(String lastName);

    List<Author> findByNationality(String nationality);
}