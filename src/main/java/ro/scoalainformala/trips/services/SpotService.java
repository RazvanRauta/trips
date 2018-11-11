package ro.scoalainformala.trips.services;

import ro.scoalainformala.trips.entitys.Spot;
import ro.scoalainformala.trips.entitys.Trip;

import java.util.List;
import java.util.Map;

public interface SpotService {
    Spot createSpot(Spot spot);
    Spot getSpot (Long id);
    Spot editSpot(Spot spot);
    void deleteSpot(Spot spot);
    void deleteSpot(Long id);
    Map<Trip,Spot> getAllSpots (Trip trip);

}

