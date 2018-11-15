package ro.scoalainformala.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.scoalainformala.trips.entitys.Spot;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.repository.SpotRepository;

import java.util.List;
import java.util.Map;

@Service
public class SpotServiceImpl implements SpotService {
    @Autowired
    SpotRepository spotRepository;

    @Override
    public Spot createSpot(Spot spot) {
        return spotRepository.save(spot);
    }

    @Override
    public Spot getSpot(Long id) {
        return spotRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("No Trips were found"));
    }

    @Override
    public Spot editSpot(Spot spot) {
        return spotRepository.save(spot);
    }

    @Override
    public void deleteSpot(Spot spot) {
       spotRepository.delete(spot);

    }

    @Override
    public void deleteSpot(Long id) {

         spotRepository.deleteById(id);

    }

    @Override
    public Map<Trip, Spot> getAllSpots(Trip trip) {
        return getAllSpots(trip);
    }
}
