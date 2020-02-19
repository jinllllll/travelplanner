package TravelPlanner.TravelPlanner.Controller;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Entity.Plan;
import TravelPlanner.TravelPlanner.Repository.PlansRepository;
import TravelPlanner.TravelPlanner.Service.PlaceService;
import TravelPlanner.TravelPlanner.Service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanController {

    PlanService planService;
    PlaceService placeService;

    @Autowired
    public PlanController(PlanService planService, PlaceService placeService) {
        super();
        this.planService = planService;
        this.placeService = placeService;
    }

    public PlanController() {

    }

    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    //save the plan
    @RequestMapping(value = "/savePlan/{planId, userId}", method = RequestMethod.POST)
    public void savePlan(@PathVariable Integer planId, Integer userId) {
        planService.savePlan(planId, userId);
    }

    //get user's planList
    @RequestMapping(value = "/plan/{userId}", method = RequestMethod.POST)
    public List<Plan> getPlans(@PathVariable Integer userId) {
        return planService.getPlansByUser(userId);
    }

    //delete plan
    @RequestMapping(value = "/deletePlan/{planId}", method = RequestMethod.POST)
    public boolean deletePlan(@PathVariable Integer planId) {
        planService.deletePlanById(planId);
        return true;
    }

    //get user's places
    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public List<Place> getPlaces(@RequestBody Integer userId) {
        return placeService.getPlacesByUserId(userId);
    }

    //add place to cur plan
    @RequestMapping(value = "/addPlace/{planId}", method = RequestMethod.POST)
    public boolean addPlace(@PathVariable Plan plan, @RequestBody Place place, @PathVariable String planId) {
        placeService.addPlace(plan, place);
        return true;
    }

    //delete place
    @RequestMapping(value = "/deletePlace/{placeId}", method = RequestMethod.POST)
    public boolean deletePlace(@RequestBody Place place) {
        placeService.deletePlace(place);
        return true;
    }

}
