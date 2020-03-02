package TravelPlanner.TravelPlanner.Entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    //get all places that a user want to visit
//    @OneToMany(mappedBy = "userId")
//    private List<Place> visitingPlaces;

    @Column(name = "user_name")
    @Length(min = 5, message = "*Your user name must have at least 5 characters")
    @NotEmpty(message = "*Please provide a user name")
    private String userName;

    @NotNull
    private Timestamp memberSince;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String userEmail;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String userPassword;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    //   // @OneToMany
//   // private List<Plan> planList;
//
//    public User() {
//    }
//
//    public User(String userEmail, String userPassword) {
//        this.userEmail = userEmail;
//        this.userPassword = userPassword;
//    }
//
////    public List<Place> getVisitingPlaces() {
////        return visitingPlaces;
////    }
////
////    public void setVisitingPlaces(List<Place> visitingPlaces) {
////        this.visitingPlaces = visitingPlaces;
////    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public Timestamp getMemberSince() {
//        return memberSince;
//    }
//
//    public void setMemberSince(Timestamp memberSince) {
//        this.memberSince = memberSince;
//    }
//
//    public String getUserEmail() {
//        return userEmail;
//    }
//
//    public void setUserEmail(String userEmail) {
//        this.userEmail = userEmail;
//    }
//
//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }

}
