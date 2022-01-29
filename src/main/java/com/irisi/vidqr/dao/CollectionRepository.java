package com.irisi.vidqr.dao;

import com.irisi.vidqr.entity.CollectionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends MongoRepository<CollectionEntity,String> {
    CollectionEntity findByName(String name);
}
