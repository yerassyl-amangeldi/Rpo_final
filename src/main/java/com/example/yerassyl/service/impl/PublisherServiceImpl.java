package com.example.yerassyl.service.impl;

import com.example.yerassyl.entity.Publisher;
import com.example.yerassyl.repository.PublisherRepository;
import com.example.yerassyl.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Long id, Publisher publisher) {
        Publisher existingPublisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));

        existingPublisher.setName(publisher.getName());
        existingPublisher.setCountry(publisher.getCountry());
        existingPublisher.setFoundedYear(publisher.getFoundedYear());
        existingPublisher.setWebsite(publisher.getWebsite());

        return publisherRepository.save(existingPublisher);
    }

    @Override
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}