package com.irisi.vidqr.services.impl;

import com.irisi.vidqr.dao.CollectionRepository;
import com.irisi.vidqr.dao.VideoRepository;
import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.entity.VideoEntity;
import com.irisi.vidqr.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public VideoEntity findById(String id) {
        Optional<VideoEntity> videoEntity = videoRepository.findById(id);
        if(videoEntity.isPresent())
            return videoEntity.get();
        return null;
    }

    @Override
    public List<VideoEntity> getAllVideos() {
        List<VideoEntity> videoEntities = videoRepository.findAll();
        if (!videoEntities.isEmpty())
            return videoEntities;
        return null;
    }

    @Override
    public String saveVideo(VideoEntity video,String id_collection) {
        if (video != null) {
            Optional<CollectionEntity> collectionEntity = collectionRepository.findById(id_collection);
            if(collectionEntity != null){
                List<VideoEntity> videos = collectionEntity.get().getVideos();
                if(!videos.isEmpty() || videos != null){
                    for (VideoEntity videoEntity: videos) {
                        if(videoEntity.getName().equals(video.getName())){
                            return "-1";
                        }
                    }
                }
                collectionEntity.get().getVideos().add(video);

                CollectionEntity  collectionSaved = collectionRepository.save(collectionEntity.get());
                return "1";
            }

            return "-2";

        }
        return "0";
    }
}
