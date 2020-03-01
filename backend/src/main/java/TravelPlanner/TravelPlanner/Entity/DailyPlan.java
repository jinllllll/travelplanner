package TravelPlanner.TravelPlanner.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class DailyPlan {

    @Id
    @GeneratedValue
    private Integer DailyPlanId;

    private Integer PlanId;

    private Integer DayNo;

    @OneToMany
    private List<Place> placeList;

    public DailyPlan() {
    }
}
