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


    //setter and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

}
