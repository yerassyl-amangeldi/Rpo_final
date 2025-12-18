package com.example.yerassyl.mapper;

import com.example.yerassyl.dto.PublisherDto;
import com.example.yerassyl.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDto toDto(Publisher publisher);

    Publisher toEntity(PublisherDto publisherDto);

    List<PublisherDto> toDtoList(List<Publisher> publishers);

    void updateEntityFromDto(PublisherDto dto, @MappingTarget Publisher entity);
}