package TravelPlanner.TravelPlanner.Controller;

import TravelPlanner.TravelPlanner.Entity.User;

import TravelPlanner.TravelPlanner.Repository.UsersRepository;
import TravelPlanner.TravelPlanner.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value={"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping(value="/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @GetMapping(value="/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getUserName() + " (" + user.getUserEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }



//    //registration ---> createUser
//    @PostMapping("/registration")
//    public User register(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    //perform Login
//    @PostMapping("/login")
//    public User login( @RequestBody User user, HttpServletResponse response) {
//        this.user = user;
//        this.response = response;
//
//        user = userService.loginUser(user);
//        if (user == null) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return null;
//        } else {
//            return user;
//        }
//    }

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
