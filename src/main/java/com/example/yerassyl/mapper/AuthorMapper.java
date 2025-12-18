package com.example.yerassyl.mapper;

import com.example.yerassyl.dto.AuthorDto;
import com.example.yerassyl.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto toDto(Author author);

    Author toEntity(AuthorDto authorDto);

    List<AuthorDto> toDtoList(List<Author> authors);

    void updateEntityFromDto(AuthorDto dto, @MappingTarget Author entity);
}