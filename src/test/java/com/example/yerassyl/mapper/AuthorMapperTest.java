package com.example.yerassyl.mapper;

import com.example.yerassyl.dto.AuthorDto;
import com.example.yerassyl.entity.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AuthorMapperTest {

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    void convertEntityToDtoTest() {
        Author author = Author.builder()
                .id(1L)
                .firstName("George")
                .lastName("Orwell")
                .birthDate(LocalDate.of(1903, 6, 25))
                .nationality("British")
                .biography("English novelist")
                .build();

        AuthorDto authorDto = authorMapper.toDto(author);

        Assertions.assertNotNull(authorDto);
        Assertions.assertNotNull(authorDto.getId());
        Assertions.assertNotNull(authorDto.getFirstName());
        Assertions.assertNotNull(authorDto.getLastName());
        Assertions.assertNotNull(authorDto.getBirthDate());
        Assertions.assertNotNull(authorDto.getNationality());
        Assertions.assertNotNull(authorDto.getBiography());

        Assertions.assertEquals(author.getId(), authorDto.getId());
        Assertions.assertEquals(author.getFirstName(), authorDto.getFirstName());
        Assertions.assertEquals(author.getLastName(), authorDto.getLastName());
        Assertions.assertEquals(author.getBirthDate(), authorDto.getBirthDate());
        Assertions.assertEquals(author.getNationality(), authorDto.getNationality());
        Assertions.assertEquals(author.getBiography(), authorDto.getBiography());
    }

    @Test
    void convertDtoToEntityTest() {
        AuthorDto authorDto = AuthorDto.builder()
                .id(2L)
                .firstName("Jane")
                .lastName("Austen")
                .birthDate(LocalDate.of(1775, 12, 16))
                .nationality("British")
                .biography("English novelist")
                .build();

        Author author = authorMapper.toEntity(authorDto);

        Assertions.assertNotNull(author);
        Assertions.assertNotNull(author.getId());
        Assertions.assertNotNull(author.getFirstName());
        Assertions.assertNotNull(author.getLastName());
        Assertions.assertNotNull(author.getBirthDate());
        Assertions.assertNotNull(author.getNationality());
        Assertions.assertNotNull(author.getBiography());

        Assertions.assertEquals(authorDto.getId(), author.getId());
        Assertions.assertEquals(authorDto.getFirstName(), author.getFirstName());
        Assertions.assertEquals(authorDto.getLastName(), author.getLastName());
        Assertions.assertEquals(authorDto.getBirthDate(), author.getBirthDate());
        Assertions.assertEquals(authorDto.getNationality(), author.getNationality());
        Assertions.assertEquals(authorDto.getBiography(), author.getBiography());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Author> authors = new ArrayList<>();

        authors.add(Author.builder()
                .id(1L)
                .firstName("George")
                .lastName("Orwell")
                .birthDate(LocalDate.of(1903, 6, 25))
                .nationality("British")
                .build());

        authors.add(Author.builder()
                .id(2L)
                .firstName("Jane")
                .lastName("Austen")
                .birthDate(LocalDate.of(1775, 12, 16))
                .nationality("British")
                .build());

        List<AuthorDto> authorsDto = authorMapper.toDtoList(authors);

        Assertions.assertNotNull(authorsDto);
        Assertions.assertNotEquals(0, authorsDto.size());
        Assertions.assertEquals(authors.size(), authorsDto.size());

        for(int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            AuthorDto authorDto = authorsDto.get(i);

            Assertions.assertNotNull(authorDto);
            Assertions.assertEquals(author.getId(), authorDto.getId());
            Assertions.assertEquals(author.getFirstName(), authorDto.getFirstName());
            Assertions.assertEquals(author.getLastName(), authorDto.getLastName());
        }
    }
}