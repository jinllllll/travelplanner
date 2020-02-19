package TravelPlanner.TravelPlanner.Repository;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Entity.Plan;
import TravelPlanner.TravelPlanner.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlansRepository extends JpaRepository<Plan, Integer> {

    Plan findPlanByPlanId(Integer id);

    List<Plan> findPlansByUserId(Integer userId);
}
