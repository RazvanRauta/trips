package ro.scoalainformala.trips.entitys;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public class TripFile {
    private Path path;
    private MultipartFile multipartFile;
    private String name;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
