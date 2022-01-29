package com.irisi.vidqr.services.impl;

import com.irisi.vidqr.dao.CollectionRepository;
import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionRepository collectionRepository;

    @Override
    public CollectionEntity findById(String id) {
        Optional<CollectionEntity> collectionEntity = collectionRepository.findById(id);
        if(collectionEntity.isPresent())
             return collectionEntity.get();
        return null;
    }

    @Override
    public List<CollectionEntity> getAllCollections() {
        List<CollectionEntity> collectionEntities = collectionRepository.findAll();
        if (!collectionEntities.isEmpty())
            return collectionEntities;
        return null;
    }

    @Override
    public int saveCollection(CollectionEntity collection) {
        if (collection != null) {
            CollectionEntity collectionEntity = collectionRepository.save(collection);
            return 1;
        }
        return 0;
    }
}
