package com.example.yerassyl.controller;

import com.example.yerassyl.dto.PublisherDto;
import com.example.yerassyl.entity.Publisher;
import com.example.yerassyl.mapper.PublisherMapper;
import com.example.yerassyl.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;
    private final PublisherMapper publisherMapper;

    @GetMapping
    public ResponseEntity<List<PublisherDto>> getAllPublishers() {
        List<PublisherDto> publishers = publisherService.findAll()
                .stream()
                .map(publisherMapper::toDto)
                .toList();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDto> getPublisherById(@PathVariable Long id) {
        return publisherService.findById(id)
                .map(publisherMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PublisherDto> createPublisher(@RequestBody PublisherDto publisherDto) {
        Publisher savedPublisher = publisherService.save(publisherMapper.toEntity(publisherDto));
        PublisherDto savedDto = publisherMapper.toDto(savedPublisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherDto> updatePublisher(@PathVariable Long id, @RequestBody PublisherDto publisherDto) {
        Publisher updatedPublisher = publisherService.update(id, publisherMapper.toEntity(publisherDto));
        PublisherDto updatedDto = publisherMapper.toDto(updatedPublisher);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}