package ro.scoalainformala.trips.services;

import ro.scoalainformala.trips.entitys.Trip;

import java.util.List;

public interface TripService {
    Trip createTrip (Trip trip);
    Trip getTrip (Long id);
    Trip editTrip(Trip trip);
    void deleteTrip(Long id);
    List<Trip> getAllTrips();
}
