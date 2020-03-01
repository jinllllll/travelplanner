package TravelPlanner.TravelPlanner.Repository;

import TravelPlanner.TravelPlanner.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer> {
    //find by userId
    User findByUserId(Integer userId);

    //find all the users on the site
    List<User> findAll();

    //find all the visitors that went to the same place
   // List<User> findByPlaceId(Integer placeId);

    //for the user to login
    User findByUserEmailAndUserPassword(String userEmail, String userPassword);

}
