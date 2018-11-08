package ro.scoalainformala.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.services.TripService;

import java.util.Date;
import java.util.Map;


@Controller
public class HomeController {

    private final TripService tripService;

    @Autowired
    public HomeController(TripService tripService) {
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
        return "tripDetails";
    }

    @RequestMapping(value = "/viewTrips", method = RequestMethod.GET)
    public String addPageTrip(@ModelAttribute Trip trip, Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "viewTrips";
    }


    @RequestMapping(value = "/createTrip")
    public String addTrip(@ModelAttribute Trip trip,Model model) {
        tripService.createTrip(trip);
        model.addAttribute("trip", tripService.createTrip(trip));
        return "index";

    }
}
