package TravelPlanner.TravelPlanner.Repository;

import TravelPlanner.TravelPlanner.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacesRepository extends JpaRepository<Place, Integer> {
    //list all the places in san francisco ---> 30 loaded places in DB
    List<Place> findAll();

    //find places by placeId
    Place findAllByPlaceId(Integer placeId);

    //find a list of places by userId
    //List<Place> findAllByUserId(Integer userId);
}
