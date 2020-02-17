package TravelPlanner.TravelPlanner.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    //one user has multiple places selected
    @ManyToOne
    @JoinColumn(name = "placeId")
    private Place place;

    @NotNull
    private String userName;

    @NotNull
    private String mumberSince;
}
