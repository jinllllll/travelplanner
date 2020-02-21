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
    //public Plan curPlan;


    //find all the places picked by user ---> might be check list in the end
    public List<Place> getPlacesByUserId(Integer userId) {
        List<Place> userPlaceList = placesRepository.findAllByUserId(userId);
        return userPlaceList;
    }


    //add a place to the plan
    public Plan addPlace(Plan plan, Place place) {
        plan.getPlaceList().add(place);
        return plansRepository.save(plan);
    }

    //delete place
    public Plan deletePlace(Integer planId, Integer placeId) {
        Plan plan = plansRepository.findPlanByPlanId(planId);
        Place place = placesRepository.findAllByPlaceId(placeId);
        plan.getPlaceList().remove(place);
        plansRepository.deleteById(planId);
        return plansRepository.save(plan);
    }

    //save the new plan into plansRepository
    public void setPlansRepository(PlansRepository newRepository) {
        this.plansRepository = newRepository;
    }

}
