package TravelPlanner.TravelPlanner.Service;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlacesService {
    PlacesRepository placesRepository;

    @Autowired
    public PlacesService(PlacesRepository placesRepository) {
        super();
        this.placesRepository = placesRepository;
    }

    public PlacesService() {

    }

    //get existing plan of a certain user ---> return List<place>
    public List<Place> getPlanByUserId(Integer userId) {
        java.util.List<Place> plan = placesRepository.findAllByUserId(userId);
    }


}
