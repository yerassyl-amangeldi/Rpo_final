package com.example.yerassyl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublisherDto {

    private Long id;
    private String name;
    private String country;
    private Integer foundedYear;
    private String website;
}