package ro.scoalainformala.trips.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.repository.TripRepository;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private final TripRepository tripRepository;

    public ImageServiceImpl(TripRepository tripService) {

        this.tripRepository = tripService;
    }

    @Override
    @Transactional
    public void saveImageFile(Long tripId, MultipartFile file) {

        try {
            Trip trip = tripRepository.findById(tripId).get();


            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            trip.setImage(byteObjects);


            tripRepository.save(trip);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}

