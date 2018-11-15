package ro.scoalainformala.trips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.scoalainformala.trips.entitys.Trip;

public interface TripRepository extends JpaRepository<Trip,Long> {

}
