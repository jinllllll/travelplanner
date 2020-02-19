package TravelPlanner.TravelPlanner.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MyPlans")
public class Plan {
    @Id
    @GeneratedValue
    @Column(name="planId")
    private Integer planId;

    //attach plan to the user ---> each user could have multiple plans
    @ManyToOne
    @JoinColumn(name="userId", insertable=false, updatable=false)
    private User user;

    private Integer userId;

    List<Place> placeList;
}
