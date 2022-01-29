package com.irisi.vidqr.services;

import com.irisi.vidqr.entity.CollectionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CollectionService {
    public CollectionEntity findById(String id);

    public List<CollectionEntity> getAllCollections();

    public ResponseEntity<CollectionEntity> saveCollection(CollectionEntity collection);

    CollectionEntity findByName(String name);
}
