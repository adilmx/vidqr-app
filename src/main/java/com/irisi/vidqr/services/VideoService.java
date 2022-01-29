package com.irisi.vidqr.services;

import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.entity.VideoEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VideoService {
    public VideoEntity findById(String id);
    public List<VideoEntity> getAllVideos();
    public String saveVideo(VideoEntity video,String id_collection);
}
