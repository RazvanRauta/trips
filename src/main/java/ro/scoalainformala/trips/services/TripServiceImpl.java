package ro.scoalainformala.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.scoalainformala.trips.entitys.Spot;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.repository.SpotRepository;
import ro.scoalainformala.trips.repository.TripRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    TripRepository tripRepository;
    SpotRepository spotRepository;

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

    @Override
    public void deleteTrip(Trip trip) {
        tripRepository.delete(trip);

    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }


    @Override
    public List<Spot> getAllSpots() {
       return spotRepository.findAll();
    }
}
