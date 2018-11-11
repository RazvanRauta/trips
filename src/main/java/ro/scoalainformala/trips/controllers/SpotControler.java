//package ro.scoalainformala.trips.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import ro.scoalainformala.trips.entitys.Spot;
//import ro.scoalainformala.trips.entitys.Trip;
//import ro.scoalainformala.trips.repository.SpotRepository;
//import ro.scoalainformala.trips.repository.TripRepository;
//import ro.scoalainformala.trips.services.ResourceNotFoundException;
//import ro.scoalainformala.trips.services.SpotService;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class SpotControler {
//    private final SpotService spotService;
//    @Autowired
//    private SpotControler(SpotService spotService){
//        this.spotService=spotService;
//    }
//    @Autowired
//    private TripRepository tripRepository;
//
//    @GetMapping("/trips/{tripId}/spots")
//    public Map<Trip,Spot> getAllSpotsByTripId(@PathVariable (value = "tripId") Long tripId){
//
//        return spotService.getAllSpots();
//    }
//
//    @PostMapping("/trips/{tripId}/spots")
//
//    public Spot createSpot(@PathVariable(value = "tripId") Long tripId, @Valid @RequestBody Spot spot){
//        return tripRepository.findById(tripId).map((trip)->{
//            spot.setTrip(trip);
//            return spotRepository.save(spot);
//        }).orElseThrow(()->new ResourceNotFoundException("TripId " + tripId + " not found"));
//    }
//
//    @PutMapping("/trips/{tripId}/spots/{spotId}")
//    public Spot updateSpot(@PathVariable (value = "tripId") Long tripId,
//                                 @PathVariable (value = "spotId") Long spotId,
//                                 @Valid @RequestBody Spot spotRequest) {
//        if(!tripRepository.existsById(tripId)) {
//            throw new ResourceNotFoundException("PostId " + tripId + " not found");
//        }
//
//        return spotRepository.findById(spotId).map(spot -> {
//            spot.setTitle(spotRequest.getTitle());
//            spot.setDescription(spotRequest.getDescription());
//            spot.setFilePath(spotRequest.getFilePath());
//            return spotRepository.save(spot);
//        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + spotId + "not found"));
//    }
//
//    @DeleteMapping("/trips/{tripId}/spots/{spotId}")
//    public ResponseEntity<?> deleteSpot(@PathVariable (value = "tripId") Long tripId,
//                                        @PathVariable (value = "spotId") Long spotId) {
//        if(!tripRepository.existsById(tripId)) {
//            throw new ResourceNotFoundException("TripId " + tripId + " not found");
//        }
//
//        return spotRepository.findById(spotId).map(spot -> {
//            spotRepository.delete(spot);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("SpotId " + spotId + " not found"));
//    }
//
//}
