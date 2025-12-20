package com.example.yerassyl.controller;

import com.example.yerassyl.dto.AuthorDto;
import com.example.yerassyl.entity.Author;
import com.example.yerassyl.mapper.AuthorMapper;
import com.example.yerassyl.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<AuthorDto> authors = authorService.findAll()
                .stream()
                .map(authorMapper::toDto)
                .toList();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        return authorService.findById(id)
                .map(authorMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<AuthorDto>> searchByLastName(@RequestParam String lastName) {
        List<AuthorDto> authors = authorService.findByLastName(lastName)
                .stream()
                .map(authorMapper::toDto)
                .toList();
        return ResponseEntity.ok(authors);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        Author savedAuthor = authorService.save(authorMapper.toEntity(authorDto));
        AuthorDto savedDto = authorMapper.toDto(savedAuthor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        Author updatedAuthor = authorService.update(id, authorMapper.toEntity(authorDto));
        AuthorDto updatedDto = authorMapper.toDto(updatedAuthor);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}