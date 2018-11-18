package ro.scoalainformala.trips.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ro.scoalainformala.trips.entitys.Trip;
import ro.scoalainformala.trips.services.ImageService;
import ro.scoalainformala.trips.services.TripService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final TripService tripService;

    public ImageController(ImageService imageService, TripService tripService) {
        this.imageService = imageService;
        this.tripService = tripService;
    }

    @GetMapping("trip/{id}/image")
    public String showUploadForm(@PathVariable Long id, Model model) {
        model.addAttribute("trip", tripService.getTrip(id));

        return "imageUploadForm";
    }

    @PostMapping("trip/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {

        imageService.saveImageFile(Long.valueOf(id), file);


        return "redirect:/home";
    }


    @GetMapping("image/{id}/tripImage")
    public void renderImageFromDB(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Trip trip = tripService.getTrip(id);

        if (trip.getImage() != null) {
            byte[] byteArray = new byte[trip.getImage().length];
            int i = 0;

            for (Byte wrappedByte : trip.getImage()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}

