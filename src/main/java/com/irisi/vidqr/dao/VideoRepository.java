package com.irisi.vidqr.dao;

import com.irisi.vidqr.entity.VideoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<VideoEntity,String> {
}
