package TravelPlanner.TravelPlanner.Service;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Entity.Plan;
import TravelPlanner.TravelPlanner.Repository.PlacesRepository;
import TravelPlanner.TravelPlanner.Repository.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {
    PlansRepository plansRepository;
    PlacesRepository placesRepository;

    @Autowired
    public PlanService(PlansRepository planRepository, PlacesRepository placesRepository ) {
        super();
        this.plansRepository = planRepository;
        this.placesRepository = placesRepository;
    }


    public PlanService() {

    }

    //listing out an user's plan list
    public List<Plan> getPlansByUser(Integer userId) {
        List<Plan> userPlanList = plansRepository.findPlansByUserId(userId);
        return userPlanList;
    }

    //get the plan by planId because user might change certain places in the certain plan
    public Plan getPlanByPlanId(Integer planId) {
        Plan plan = plansRepository.findPlanByPlanId(planId);
        return plan;
    }

    //add Plan
    public Plan addPlan(Plan plan) {
        return plansRepository.save(plan);
    }

    //delete plan
    public boolean deletePlanById(Integer planId) {
        Plan plan = plansRepository.getOne(planId);
        plansRepository.delete(plan);
        return true;
    }

    //save the plans into plansRepository
    public void savePlan(Integer planId, Integer userId) {
        Plan plan = plansRepository.findPlanByPlanId(planId);
        List<Plan> userPlanList = plansRepository.findPlansByUserId(userId);

        userPlanList.add(plan);
        plansRepository.save(new ArrayList<Plan>(userPlanList));
    }
}
