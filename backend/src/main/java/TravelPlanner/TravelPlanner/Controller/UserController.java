package TravelPlanner.TravelPlanner.Controller;

import TravelPlanner.TravelPlanner.Entity.User;

import TravelPlanner.TravelPlanner.Repository.UsersRepository;
import TravelPlanner.TravelPlanner.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }
    //registration ---> createUser
    @PostMapping("/registration")
    public User register(@RequestBody User user) {
        return userService.createUser(user);
    }

    //perform Login
    @PostMapping("/login")
    public User login( @RequestBody User user, HttpServletResponse response) {
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
