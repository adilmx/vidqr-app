package com.irisi.vidqr.rest;

import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.services.CollectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vidqr/collections")
@RequiredArgsConstructor
public class CollectionRest {
    private final CollectionService collectionService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RouterOperation(operation = @Operation(description = "Get  Collection By Id", operationId = "collection", tags = "collection",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CollectionEntity.class)))))
    @GetMapping("/id/{id}")
    public CollectionEntity getCollection(@PathVariable String id) {
        return collectionService.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/")
    @RouterOperation(operation = @Operation(description = "Get all Collection ", operationId = "all", tags = "collections",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CollectionEntity.class)))))
    public List<CollectionEntity> getAllCollections() {
        return collectionService.getAllCollections();
    }

    @PostMapping("/")
    @RouterOperation(operation = @Operation(description = "Add Collection ", operationId = "add", tags = "Collection",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CollectionEntity.class)))))
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CollectionEntity> saveCollection(@RequestBody CollectionEntity collection) {
        return collectionService.saveCollection(collection);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/name/{name}")
    @RouterOperation(operation = @Operation(description = "Find by name ", operationId = "find", tags = "Collection",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CollectionEntity.class)))))
    public CollectionEntity findByName(@PathVariable String name) {
        return collectionService.findByName(name);
    }
}
