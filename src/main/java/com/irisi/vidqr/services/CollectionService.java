package com.irisi.vidqr.services;

import com.irisi.vidqr.entity.CollectionEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CollectionService {
    public CollectionEntity findById(String id);
    public List<CollectionEntity> getAllCollections();
    public int saveCollection(CollectionEntity collection);
}
