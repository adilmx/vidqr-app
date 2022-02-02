package com.irisi.vidqr.services.impl;

import com.irisi.vidqr.dao.VideoRepository;
import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.entity.VideoEntity;
import com.irisi.vidqr.services.CollectionService;
import com.irisi.vidqr.services.VideoService;
import com.irisi.vidqr.utils.UploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    private final CollectionService collectionService;
    private final UploadUtil uploadUtil;


    @Override
    public VideoEntity findById(String id) {
        Optional<VideoEntity> videoEntity = videoRepository.findById(id);
        return videoEntity.orElse(null);
    }

    @Override
    public List<VideoEntity> getAllVideos() {
        List<VideoEntity> videoEntities = videoRepository.findAll();
        if (!videoEntities.isEmpty())
            return videoEntities;
        return null;
    }

    @Override
    @Async
    public String save(VideoEntity video, String idCollection) {
        if (video != null) {
            CollectionEntity collectionEntity = collectionService.findById(idCollection);
            if (collectionEntity != null) {
                List<VideoEntity> videos = collectionEntity.getVideos();
                if (!videos.isEmpty()) {
                    for (VideoEntity videoEntity : videos) {
                        if (videoEntity.getName().equals(video.getName())) {
                            return "-1";
                        }
                    }
                }
                video.setUrl(uploadUtil.upload(video.getUrl()));
                collectionEntity.getVideos().add(video);
                System.out.println(video.getUrl());
                collectionService.update(collectionEntity);
                return "1";
            }
            return "-2";
        }
        return "0";
    }

    @Override
    public VideoEntity findByName(String name) {
        return videoRepository.findByName(name);
    }

}
