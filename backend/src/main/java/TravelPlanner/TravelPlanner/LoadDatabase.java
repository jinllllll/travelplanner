package TravelPlanner.TravelPlanner;

import TravelPlanner.TravelPlanner.Entity.Place;
import TravelPlanner.TravelPlanner.Entity.User;
import TravelPlanner.TravelPlanner.Repository.PlacesRepository;
import TravelPlanner.TravelPlanner.Repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PlacesRepository placesRepository) {
        return args -> {
            Place place = new Place();
            place.setLatitude(1.1);
            place.setLongitude(2.1);
            place.setPlaceName("place 1");
            place.setPlaceInformation("some info");
            place.setImageURL("no images");
            place.setOpenTime("9-5");
            place.setDuration(1.5);
            place.setAddress("some address");
            log.info("preloading " + placesRepository.save(place));
            Place place2 = new Place();
            place2.setLatitude(33.2);
            place2.setLongitude(34.6);
            place2.setPlaceName("place 2");
            place2.setPlaceInformation("some info");
            place2.setImageURL("no images");
            place2.setOpenTime("9-5");
            place2.setDuration(2.0);
            place2.setAddress("some address");
            log.info("preloading " + placesRepository.save(place2));
        };
    }
}