package com.example.yerassyl.service;

import com.example.yerassyl.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    List<Publisher> findAll();

    Optional<Publisher> findById(Long id);

    Publisher save(Publisher publisher);

    Publisher update(Long id, Publisher publisher);

    void deleteById(Long id);
}