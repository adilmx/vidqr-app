package com.irisi.vidqr.rest;

import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vidqr/collection")
public class CollectionRest {
    @Autowired
    private CollectionService collectionService;

    @GetMapping("/id/{id}")
    public CollectionEntity getCollection(@PathVariable String id){
    return collectionService.findById(id);
    }

    @GetMapping("/allcollection")
    public List<CollectionEntity> getAllCollections(){
        return collectionService.getAllCollections();
    }

}
