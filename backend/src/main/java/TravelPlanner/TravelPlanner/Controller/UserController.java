package TravelPlanner.TravelPlanner.Controller;

import TravelPlanner.TravelPlanner.Entity.User;

import TravelPlanner.TravelPlanner.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.text.normalizer.ICUBinary;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    UserService userService;
    private User user;
    private HttpServletResponse response;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    public UserController() {

    }

    //registration ---> createUser
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public User register(@RequestBody User user) {
        return userService.createUser(user);
    }

    //perform Login
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@Validated(ICUBinary.Authenticate.class) @RequestBody User user, HttpServletResponse response) {
        this.user = user;
        this.response = response;

        user = userService.loginUser(user);
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        } else {
            return user;
        }
    }

    /*
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
    */
}
