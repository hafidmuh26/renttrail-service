package batchfour.teamtwo.renttrailservice.models;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PartnerImageRequest {

    private String filename;
    private String url;
    private String type;
    private Long size;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public static PartnerImageRequest from(Integer id, Path path) throws IOException {
        String name = path.getFileName().toString();
        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/outlet/" + id + "/images")
                .path(name).toUriString();
        PartnerImageRequest model =new PartnerImageRequest();
        model.setFilename(name);
        model.setUrl(uri);
        model.setType(Files.probeContentType(path));
        model.setSize(Files.size(path));

        return model;
    }
}
