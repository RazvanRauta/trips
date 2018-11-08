package ro.scoalainformala.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.repository.TripRepository;

import java.util.ArrayList;
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
    public List<Trip> getAllEntireTripsList(Long tripID) {
        List<Trip> tcList = new ArrayList<>();
        List<Trip> all = getAllTrips();
        for (Trip t : all) {
            if (getTrip(tripID).equals(tripID)) {
                tcList.add(t);
                break;
            }
        }
        for (Trip t : all) {
            if (getTrip(tripID).equals(tripID)) {
                tcList.add(t);
            }
        }


        return tcList;
    }
}
