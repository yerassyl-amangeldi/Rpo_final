package com.example.yerassyl.mapper;

import com.example.yerassyl.dto.BookDto;
import com.example.yerassyl.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "publisher.id", target = "publisherId")
    @Mapping(source = "publisher.name", target = "publisherName")
    @Mapping(target = "authorIds", expression = "java(book.getAuthors().stream().map(a -> a.getId()).collect(java.util.stream.Collectors.toSet()))")
    @Mapping(target = "authorNames", expression = "java(book.getAuthors().stream().map(a -> a.getFirstName() + \" \" + a.getLastName()).collect(java.util.stream.Collectors.toSet()))")
    BookDto toDto(Book book);

    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "authors", ignore = true)
    Book toEntity(BookDto bookDto);

    List<BookDto> toDtoList(List<Book> books);

    void updateEntityFromDto(BookDto dto, @MappingTarget Book entity);
}