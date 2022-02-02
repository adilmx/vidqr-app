package com.irisi.vidqr.rest;

import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.services.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vidqr/collections")
@RequiredArgsConstructor
public class CollectionRest {
    private final CollectionService collectionService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/id/{id}")
    public CollectionEntity getCollection(@PathVariable String id) {
        return collectionService.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/")
    public List<CollectionEntity> getAllCollections() {
        return collectionService.getAllCollections();
    }

    @PostMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CollectionEntity> saveCollection(@RequestBody CollectionEntity collection) {
        return collectionService.saveCollection(collection);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/name/{name}")
    public CollectionEntity findByName(@PathVariable String name) {
        return collectionService.findByName(name);
    }
}
