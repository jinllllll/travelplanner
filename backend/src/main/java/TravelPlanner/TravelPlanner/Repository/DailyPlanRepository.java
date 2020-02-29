package TravelPlanner.TravelPlanner.Repository;

import TravelPlanner.TravelPlanner.Entity.DailyPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DailyPlanRepository extends JpaRepository<DailyPlan, Integer> {
}
