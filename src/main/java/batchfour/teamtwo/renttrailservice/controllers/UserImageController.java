package batchfour.teamtwo.renttrailservice.controllers;


import batchfour.teamtwo.renttrailservice.entities.User;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.models.UserImageRequest;
import batchfour.teamtwo.renttrailservice.services.ImageService;
import batchfour.teamtwo.renttrailservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/users/{id}/images")
@RestController
public class UserImageController {

    @Autowired
    private UserService service;

    @Autowired
    private ImageService<User> imageService;

    @PostMapping
    public ResponseMessage<UserImageRequest> upload(@PathVariable Integer id,
                                                    @RequestParam MultipartFile file) throws IOException {

        User entity = service.finById(id);
        Path path = imageService.save(entity, file);
        UserImageRequest model = UserImageRequest.from(id, path);
        entity.setPicture(model.getUrl());
        service.save(entity);

        return ResponseMessage.success(model);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> download(@PathVariable Integer id, @PathVariable String filename) throws IOException {
        User entity = service.finById(id);
        Resource resource = imageService.load(entity, filename);

        String mediaTypes = URLConnection.guessContentTypeFromName(resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(mediaTypes))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @DeleteMapping("/{filename}")
    public ResponseMessage<Boolean> delete(@PathVariable Integer id, @PathVariable String filename) throws IOException{
        User entity = service.finById(id);
        imageService.delete(entity, filename);

        return ResponseMessage.success(Boolean.TRUE);
    }

    @GetMapping
    public ResponseMessage<List<UserImageRequest>> list(@PathVariable Integer id) throws IOException {
        User entity = service.finById(id);
        List<Path> paths = imageService.list(entity);

        List<UserImageRequest> models = new ArrayList<>();
        for (Path path : paths) {
            UserImageRequest model = UserImageRequest.from(id, path);
            models.add(model);
        }
        return ResponseMessage.success(models);
    }
}
