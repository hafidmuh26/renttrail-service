package batchfour.teamtwo.renttrailservice.controllers;


import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.models.PartnerImageRequest;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.ImageService;
import batchfour.teamtwo.renttrailservice.services.PartnerService;
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

@RequestMapping("/partner/{id}/images")
@RestController
public class PartnerImageController {

    @Autowired
    private PartnerService service;

    @Autowired
    private ImageService<Partner> imageService;

    @PostMapping
    public ResponseMessage<PartnerImageRequest> upload(@PathVariable Integer id,
                                                       @RequestParam MultipartFile file) throws IOException {

        Partner entity = service.findById(id);
        Path path = imageService.save(entity, file);
        PartnerImageRequest model = PartnerImageRequest.from(id, path);
        entity.setPicture(model.getUrl());
        service.save(entity);

        return ResponseMessage.success(model);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> download(@PathVariable Integer id, @PathVariable String filename) throws IOException {
        Partner entity = service.findById(id);
        Resource resource = imageService.load(entity, filename);

        String mediaTypes = URLConnection.guessContentTypeFromName(resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(mediaTypes))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @DeleteMapping("/{filename}")
    public ResponseMessage<Boolean> delete(@PathVariable Integer id, @PathVariable String filename) throws IOException{
        Partner entity = service.findById(id);
        imageService.delete(entity, filename);

        return ResponseMessage.success(Boolean.TRUE);
    }

    @GetMapping
    public ResponseMessage<List<PartnerImageRequest>> list(@PathVariable Integer id) throws IOException {
        Partner entity = service.findById(id);
        List<Path> paths = imageService.list(entity);

        List<PartnerImageRequest> models = new ArrayList<>();
        for (Path path : paths) {
            PartnerImageRequest model = PartnerImageRequest.from(id, path);
            models.add(model);
        }
        return ResponseMessage.success(models);
    }

}
