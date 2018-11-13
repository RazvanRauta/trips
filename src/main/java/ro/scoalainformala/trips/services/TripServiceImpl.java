package ro.scoalainformala.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.repository.TripRepository;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    TripRepository tripRepository;

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip getTrip(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("No Trips were found"));
    }

    @Override
    public Trip editTrip(Trip trip) {
        tripRepository.delete(trip);
        return tripRepository.save(trip);
    }


    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }


}
