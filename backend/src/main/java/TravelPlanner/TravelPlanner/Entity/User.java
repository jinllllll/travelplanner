package TravelPlanner.TravelPlanner.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    //get all places that a user want to visit
    @OneToMany(mappedBy = "userId")
    private List<Place> visitingPlaces;

    @NotNull
    private String userName;

    @NotNull
    private String memberSince;

    @NotNull
    private String userEmail;

    @NotNull
    private String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public List<Place> getVisitingPlaces() {
        return visitingPlaces;
    }

    public void setVisitingPlaces(List<Place> visitingPlaces) {
        this.visitingPlaces = visitingPlaces;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
