package com.example.yerassyl.service;

import com.example.yerassyl.entity.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PublisherServiceTest {

    @Autowired
    private PublisherService publisherService;

    @Test
    void getAllTest() {
        List<Publisher> publishers = publisherService.findAll();
        Assertions.assertNotNull(publishers);
    }

    @Test
    void getByIdTest() {
        Publisher newPublisher = Publisher.builder()
                .name("Test Publisher")
                .country("USA")
                .foundedYear(2000)
                .build();

        Publisher created = publisherService.save(newPublisher);
        Publisher found = publisherService.findById(created.getId()).orElse(null);

        Assertions.assertNotNull(found);
        Assertions.assertNotNull(found.getId());
        Assertions.assertNotNull(found.getName());
    }

    @Test
    void addTest() {
        Publisher publisher = Publisher.builder()
                .name("Penguin Random House")
                .country("USA")
                .foundedYear(2013)
                .website("https://www.penguinrandomhouse.com")
                .build();

        Publisher added = publisherService.save(publisher);

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getName());

        Publisher found = publisherService.findById(added.getId()).orElse(null);

        Assertions.assertNotNull(found);
        Assertions.assertEquals(added.getId(), found.getId());
        Assertions.assertEquals(added.getName(), found.getName());
    }
}