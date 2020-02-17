package TravelPlanner.TravelPlanner.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer placeId;

    @NotNull
    private String placeName;
    @NotNull
    private String placeInformation;
    @NotNull
    private String openTime;


    List<String> visitors;

    //constructor
    public Place() {

    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceInformation() {
        return placeInformation;
    }

    public void setPlaceInformation(String placeInformation) {
        this.placeInformation = placeInformation;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }
}
