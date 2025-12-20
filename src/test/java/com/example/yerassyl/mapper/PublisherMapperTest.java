package com.example.yerassyl.mapper;

import com.example.yerassyl.dto.PublisherDto;
import com.example.yerassyl.entity.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PublisherMapperTest {

    @Autowired
    private PublisherMapper publisherMapper;

    @Test
    void convertEntityToDtoTest() {
        Publisher publisher = Publisher.builder()
                .id(1L)
                .name("Penguin Random House")
                .country("USA")
                .foundedYear(2013)
                .website("https://www.penguinrandomhouse.com")
                .build();

        PublisherDto publisherDto = publisherMapper.toDto(publisher);

        Assertions.assertNotNull(publisherDto);
        Assertions.assertNotNull(publisherDto.getId());
        Assertions.assertNotNull(publisherDto.getName());
        Assertions.assertNotNull(publisherDto.getCountry());
        Assertions.assertNotNull(publisherDto.getFoundedYear());
        Assertions.assertNotNull(publisherDto.getWebsite());

        Assertions.assertEquals(publisher.getId(), publisherDto.getId());
        Assertions.assertEquals(publisher.getName(), publisherDto.getName());
        Assertions.assertEquals(publisher.getCountry(), publisherDto.getCountry());
        Assertions.assertEquals(publisher.getFoundedYear(), publisherDto.getFoundedYear());
        Assertions.assertEquals(publisher.getWebsite(), publisherDto.getWebsite());
    }

    @Test
    void convertDtoToEntityTest() {
        PublisherDto publisherDto = PublisherDto.builder()
                .id(2L)
                .name("HarperCollins")
                .country("USA")
                .foundedYear(1989)
                .website("https://www.harpercollins.com")
                .build();

        Publisher publisher = publisherMapper.toEntity(publisherDto);

        Assertions.assertNotNull(publisher);
        Assertions.assertNotNull(publisher.getId());
        Assertions.assertNotNull(publisher.getName());
        Assertions.assertNotNull(publisher.getCountry());
        Assertions.assertNotNull(publisher.getFoundedYear());
        Assertions.assertNotNull(publisher.getWebsite());

        Assertions.assertEquals(publisherDto.getId(), publisher.getId());
        Assertions.assertEquals(publisherDto.getName(), publisher.getName());
        Assertions.assertEquals(publisherDto.getCountry(), publisher.getCountry());
        Assertions.assertEquals(publisherDto.getFoundedYear(), publisher.getFoundedYear());
        Assertions.assertEquals(publisherDto.getWebsite(), publisher.getWebsite());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Publisher> publishers = new ArrayList<>();

        publishers.add(Publisher.builder()
                .id(1L)
                .name("Penguin Random House")
                .country("USA")
                .foundedYear(2013)
                .build());

        publishers.add(Publisher.builder()
                .id(2L)
                .name("HarperCollins")
                .country("USA")
                .foundedYear(1989)
                .build());

        List<PublisherDto> publishersDto = publisherMapper.toDtoList(publishers);

        Assertions.assertNotNull(publishersDto);
        Assertions.assertNotEquals(0, publishersDto.size());
        Assertions.assertEquals(publishers.size(), publishersDto.size());

        for(int i = 0; i < publishers.size(); i++) {
            Publisher publisher = publishers.get(i);
            PublisherDto publisherDto = publishersDto.get(i);

            Assertions.assertNotNull(publisherDto);
            Assertions.assertEquals(publisher.getId(), publisherDto.getId());
            Assertions.assertEquals(publisher.getName(), publisherDto.getName());
        }
    }
}