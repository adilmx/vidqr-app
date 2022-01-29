package com.irisi.vidqr.rest;

import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.entity.VideoEntity;
import com.irisi.vidqr.services.CollectionService;
import com.irisi.vidqr.services.VideoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vidqr/video")
public class VideoRest {
    @Autowired
    private VideoService videoService;

    @GetMapping("/id/{id}")
    public VideoEntity getVideo(@PathVariable String id){
        return videoService.findById(id);
    }

    @GetMapping("/allvideos")
    public List<VideoEntity> getAllCollections(){
        return videoService.getAllVideos();
    }

    @PostMapping("/savevideo/id_collection/{id_collection}")
    public ResponseEntity<String> save(@RequestBody VideoEntity video,@PathVariable String id_collection){
        String res = videoService.saveVideo(video,id_collection);
        if(res.equals("0")){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(res);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);

    }


    
}
