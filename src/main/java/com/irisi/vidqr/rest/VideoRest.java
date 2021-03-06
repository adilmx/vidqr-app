package com.irisi.vidqr.rest;

import com.irisi.vidqr.entity.VideoEntity;
import com.irisi.vidqr.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vidqr/video")
@RequiredArgsConstructor
public class VideoRest {

    private final VideoService videoService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/id/{id}")
    public VideoEntity getVideo(@PathVariable String id) {
        return videoService.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/allvideos")
    public List<VideoEntity> getAllCollections() {
        return videoService.getAllVideos();
    }


    @PostMapping("/savevideo/idCollection/{idCollection}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> save(@RequestBody VideoEntity video, @PathVariable String idCollection) {
        String res = videoService.save(video, idCollection);
        if (res.equals("0")) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(res);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    @GetMapping("/name/{name}")
    public VideoEntity findByName(@PathVariable String name) {
        return videoService.findByName(name);
    }
}
