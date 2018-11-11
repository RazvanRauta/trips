package ro.scoalainformala.trips.controllers;


import jdk.management.resource.ResourceRequestDeniedException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.repository.TripRepository;
import ro.scoalainformala.trips.services.ResourceNotFoundException;
import ro.scoalainformala.trips.services.TripService;


import javax.validation.Valid;
import java.awt.print.Pageable;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());

        return "index";

    }

    @RequestMapping(value = "/seeTrip", method = RequestMethod.GET)
    public String home(@RequestParam Long id ,Model model) {
        model.addAttribute("trip", tripService.getTrip(id));
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());
        return "tripDetails";
    }

    @GetMapping(value = "/editTrip")
    public String editTrip(@RequestParam Long tripId,@ModelAttribute Trip trip,Model model){
        tripService.deleteTrip(tripId);
        model.addAttribute("trip", tripService.createTrip(trip));
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());
        return "editTrip";
    }

    @RequestMapping(value = "/viewTrips", method = RequestMethod.GET)
    public String addPageTrip(@ModelAttribute Trip trip, Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        model.addAttribute("tripsList", tripService.getAllTrips());
        return "viewTrips";
    }


    @RequestMapping(value = "/createTrip")
    public String addTrip(@ModelAttribute Trip trip,Model model) {
        tripService.createTrip(trip);
        model.addAttribute("trip", tripService.createTrip(trip));
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());
        return "index";
    }

    @RequestMapping(value = "/deleteTrip/{id}")
    public  String deleteTrip(@PathVariable Long id, @ModelAttribute Trip trip,Model model){
        tripService.deleteTrip(id);
        model.addAttribute("trip", new Trip());
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());
        return "viewTrips";

    }



    @GetMapping(value = "/profile")
    public String profile(Model model){
        model.addAttribute("trip", new Trip());

        return  "profile";
    }

    @GetMapping(value = "/image/{id}")
    public @ResponseBody byte[] getImage(@PathVariable(value = "id") String id) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/static/img/"+id);
        return IOUtils.toByteArray(in);
    }

}
