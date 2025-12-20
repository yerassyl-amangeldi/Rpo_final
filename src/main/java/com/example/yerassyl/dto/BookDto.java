package com.example.yerassyl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long id;
    private String title;
    private String isbn;
    private LocalDate publicationDate;
    private Integer pages;
    private String language;
    private String description;
    private Long publisherId;
    private String publisherName;
    private Set<Long> authorIds;
    private Set<String> authorNames;
}