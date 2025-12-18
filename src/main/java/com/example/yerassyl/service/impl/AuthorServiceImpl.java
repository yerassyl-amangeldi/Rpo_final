package com.example.yerassyl.service.impl;

import com.example.yerassyl.entity.Author;
import com.example.yerassyl.repository.AuthorRepository;
import com.example.yerassyl.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author author) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setLastName(author.getLastName());
        existingAuthor.setBirthDate(author.getBirthDate());
        existingAuthor.setNationality(author.getNationality());
        existingAuthor.setBiography(author.getBiography());

        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    @Override
    public List<Author> findByNationality(String nationality) {
        return authorRepository.findByNationality(nationality);
    }
}