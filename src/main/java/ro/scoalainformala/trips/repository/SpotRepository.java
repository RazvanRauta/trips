package ro.scoalainformala.trips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.scoalainformala.trips.entitys.Spot;

public interface SpotRepository extends JpaRepository<Spot,Long> {
}
