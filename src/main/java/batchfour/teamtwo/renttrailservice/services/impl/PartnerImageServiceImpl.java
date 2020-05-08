package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.configs.ApplicationProperties;
import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerImageServiceImpl implements ImageService<Partner> {

    @Autowired
    private ApplicationProperties properties;

    private Path parentDir;

    @PostConstruct
    public void init() throws IOException {
        parentDir = Paths.get(properties.getDataDir(), "partner").toAbsolutePath().normalize();

        Files.createDirectories(parentDir);
    }

    @Override
    public Path save(Partner entity, MultipartFile file) throws IOException {

        Path dir = parentDir.resolve(entity.getId().toString());
        Files.createDirectories(dir);

        Path target = dir.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        return target;
    }

    @Override
    public Resource load(Partner entity, String fileName) throws IOException {
        Path target = parentDir.resolve(entity.getId().toString()).resolve(fileName);

        Resource resource = new UrlResource(target.toUri());
        return resource;
    }

    @Override
    public List<Path> list(Partner entity) throws IOException {
        Path dir = parentDir.resolve(entity.getId().toString());
        return Files.isDirectory(dir) ? Files.list(dir).collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }

    @Override
    public void delete(Partner entity, String fileName) throws IOException {
        Path target = parentDir.resolve(entity.getId().toString()).resolve(fileName);
        Files.delete(target);
    }
}
