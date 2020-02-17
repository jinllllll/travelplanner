package TravelPlanner.TravelPlanner.Controller;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Entity.User;
import TravelPlanner.TravelPlanner.Repository.PlacesRepository;
import TravelPlanner.TravelPlanner.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersController {
    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(value = "/user/place/{placeId}", method = RequestMethod.POST)
    public ResponseEntity<User> addPlaceForUser(@PathVariable("userId") Integer userId, @PathVariable("placeId") Integer placeId) {
        Place newPlace = placesRepository.getOne(placeId);

        //use optional in case the user is not existed
        Optional<User> user = usersRepository.findById(userId);
        if (user.isPresent()) {
            List<Place> userVisitingList = placesRepository.findAllByUserId(userId);
            userVisitingList.add(newPlace);
            user.setVisitingPlaces(userVisitingList);
            usersRepository.save();
            return ResponseEntity.ok(user);
        } else {
            User tempUser = new User();
            List<Place> tempList = new ArrayList<Place>();
            tempList.add(newPlace);
            return ResponseEntity.ok(tempUser);
        }
    }
}
