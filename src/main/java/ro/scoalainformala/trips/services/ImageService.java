package ro.scoalainformala.trips.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(Long tripId, MultipartFile file);
}
