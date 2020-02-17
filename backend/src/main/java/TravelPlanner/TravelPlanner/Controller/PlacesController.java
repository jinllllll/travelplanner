package TravelPlanner.TravelPlanner.Controller;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Entity.User;
import TravelPlanner.TravelPlanner.Repository.PlacesRepository;
import TravelPlanner.TravelPlanner.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlacesController {
    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(value = "/user/place/{placeId}", method = RequestMethod.POST)
    public ResponseEntity<Place> addPlaceForUser(@PathVariable("userId") Integer userId, @PathVariable("placeId") Integer placeId) {

        //use optional in case the user is not existed
        Optional<User> user = usersRepository.findById(userId);

        Place newPlace = placesRepository.findById(placeId);

        if (user.isPresent()) {
           placesRepository.findAllByUserId(userId).save(place);
        }

        Place place = placesRepository.getOne(placeId);

        //may not need now, because we load the places ourselves
        if (place == null) {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }


        usersRepository.save(user);
        return ResponseEntity.ok(user);
    }
}
