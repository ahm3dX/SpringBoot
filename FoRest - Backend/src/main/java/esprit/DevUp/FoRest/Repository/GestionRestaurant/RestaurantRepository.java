package esprit.DevUp.FoRest.Repository.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.Restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
