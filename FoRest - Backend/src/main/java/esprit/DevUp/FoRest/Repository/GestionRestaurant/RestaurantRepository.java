package esprit.DevUp.FoRest.Repository.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.others.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
