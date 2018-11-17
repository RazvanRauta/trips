package ro.scoalainformala.trips.controllers;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.repository.TripRepository;
import ro.scoalainformala.trips.services.TripService;


import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;


@Controller
public class TripController {
    private final TripService tripService;
    private TripRepository tripRepository;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(value = {"/", "/home"})
    public String homePage(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());

        return "index";

    }

    @RequestMapping(value = "/seeTrip", method = RequestMethod.GET)
    public String home(@PathVariable(required = false, name = "id") @RequestParam Long id, Model model) {
        model.addAttribute("trip", tripService.getTrip(id));
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());
        return "tripDetails";
    }
    @RequestMapping(value = "/seeTrip/{id}", method = RequestMethod.GET)
    public String trip(@PathVariable(required = false, name = "id") Long id, Model model) {
        model.addAttribute("trip", tripService.getTrip(id));
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());
        return "tripDetails";
    }

    @RequestMapping(value = {"/editTrip/{id}"}, method = RequestMethod.GET)
    public String tripEditForm(@PathVariable(required = false, name = "id") Long id, Model model) {
        if (id != 0) {
            model.addAttribute("trip", tripService.getTrip(id));
            return "editTrip";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = {"/edit/{id}"})
    public String tripEdit(@PathVariable(required = false, name = "id") Long id, @ModelAttribute Trip trip, Model model) {
        model.addAttribute("trip", tripService.getTrip(id));
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());
        trip.setId(id);
        tripService.editTrip(trip);
        return "index";
    }



    @RequestMapping(value = "/viewTrips", method = RequestMethod.GET)
    public String addPageTrip(@ModelAttribute Trip trip, Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        model.addAttribute("tripsList", tripService.getAllTrips());
        return "viewTrips";
    }


    @PostMapping(value = "/createTrip")
    public String addTrip(@ModelAttribute Trip trip,Model model) {
        tripService.createTrip(trip);
        model.addAttribute("trip", tripService.createTrip(trip));

        return "redirect:/home";
    }

    @RequestMapping(value = "/deleteTrip/{id}")
    public  String deleteTrip(@PathVariable Long id, @ModelAttribute Trip trip,Model model){
        tripService.deleteTrip(id);
        model.addAttribute("trip", new Trip());
        model.addAttribute("tripsList", tripService.getAllTrips());
        model.addAttribute("trips", tripService.getAllTrips());
        return "index";

    }



    @GetMapping(value = "/profile")
    public String profile() {

        return  "profile";
    }

    @GetMapping(value = "/image/{id}")
    public @ResponseBody byte[] getImage(@PathVariable(value = "id") String id) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/static/img/"+id);
        return IOUtils.toByteArray(in);
    }

}
