package com.irisi.vidqr.services.impl;

import com.irisi.vidqr.dao.CollectionRepository;
import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.services.CollectionService;
import com.irisi.vidqr.utils.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;
    private final UploadUtil uploadUtil;


    @Override
    public CollectionEntity findById(String id) {
        Optional<CollectionEntity> collectionEntity = collectionRepository.findById(id);
        return collectionEntity.orElse(null);
    }

    @Override
    public List<CollectionEntity> getAllCollections() {
        return collectionRepository.findAll();
    }

    @Override
    public ResponseEntity<CollectionEntity> saveCollection(CollectionEntity collection) {
        if (collection != null) {
            if (findByName(collection.getName()) != null) {
                return ResponseEntity.status(422).body(null);
            }
            collection.setVideos(new ArrayList<>());
            collection.setImage_src(uploadUtil.upload(collection.getImage_src()));
            CollectionEntity saved = collectionRepository.save(collection);
            ResponseEntity.status(201).body(saved);
        }
        return null;
    }

    @Override
    public CollectionEntity update(CollectionEntity collection) {
        if (collection != null) {
            CollectionEntity saved = collectionRepository.save(collection);
            return saved;
        }
        return null;
    }

    @Override
    public CollectionEntity findByName(String name) {
        return collectionRepository.findByName(name);
    }
}
