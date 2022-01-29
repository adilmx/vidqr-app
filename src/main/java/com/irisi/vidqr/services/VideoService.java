package com.irisi.vidqr.services;

import com.irisi.vidqr.entity.VideoEntity;

import java.util.List;


public interface VideoService {
    public VideoEntity findById(String id);

    public List<VideoEntity> getAllVideos();

    public String save(VideoEntity video, String idCollection);

    VideoEntity findByName(String name);
}
