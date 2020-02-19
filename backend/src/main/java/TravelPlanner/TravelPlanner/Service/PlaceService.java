package TravelPlanner.TravelPlanner.Service;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Entity.Plan;
import TravelPlanner.TravelPlanner.Repository.PlacesRepository;
import TravelPlanner.TravelPlanner.Repository.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    PlansRepository plansRepository;
    PlacesRepository placesRepository;

    @Autowired
    public PlaceService(PlansRepository plansRepository, PlacesRepository placesRepository ) {
        super();
        this.plansRepository = plansRepository;
        this.placesRepository = placesRepository;
    }

    public PlaceService() {

    }

    //not sure if this curPlan is unique or save????
    public Plan curPlan;


    //find all the places picked by user ---> might be check list in the end
    public List<Place> getPlacesByUserId(Integer userId) {
        List<Place> userPlaceList = placesRepository.findAllByUserId(userId);
        return userPlaceList;
    }


    //add a place to the plan
    public void addPlace(Plan plan, Place place) {
        curPlan = plan;
        curPlan.getPlaceList().add(place);
        plansRepository.save(curPlan);
    }

    //delete place
    public boolean deletePlace(Place place) {
        curPlan.getPlaceList().remove(place);
        return true;
    }

    //save the new plan into plansRepository
    public void setPlansRepository(PlansRepository newRepository) {
        this.plansRepository = newRepository;
    }

}
