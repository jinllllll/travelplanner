package TravelPlanner.TravelPlanner.Controller;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Entity.Plan;
import TravelPlanner.TravelPlanner.Entity.User;
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
    @RequestMapping(value = "/savePlan", method = RequestMethod.POST)
    public Plan addPlan(@RequestBody Plan plan) {
        return planService.addPlan(plan);
    }

    //get user's plan
    @RequestMapping(value = "/plan", method = RequestMethod.POST)
    public List<Plan> getPlans(@RequestBody Plan plan) {

        return planService.getPlansByUser();
    }

    //delete plan
    @RequestMapping(value = "/deletePlan/{planId}", method = RequestMethod.POST)
    public boolean deletePlan(@PathVariable int planId, @RequestBody Plan plan) {
        planService.deletePlanById(planId);
        return true;
    }

    //get user's places
    @RequestMapping(value = "/places", method = RequestMethod.POST)
    public List<Place> getPlaces(@RequestBody Integer userId) {
        return placeService.getPlacesByUserId(userId);
    }

    //delete place
    @RequestMapping(value = "/deletePlace/{placeId}", method = RequestMethod.POST)
    public boolean deletePlace(@RequestBody Place place) {
        placeService.deletePlace(place);
        return true;
    }

}
