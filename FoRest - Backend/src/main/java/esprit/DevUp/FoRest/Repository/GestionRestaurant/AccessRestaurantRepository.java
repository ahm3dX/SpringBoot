package esprit.DevUp.FoRest.Repository.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.others.Restaurant;
import esprit.DevUp.FoRest.Entity.User;
import esprit.DevUp.FoRest.Entity.others.accessRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessRestaurantRepository extends JpaRepository<accessRestaurant,Integer> {
List<User>findByRestaurants(Restaurant restaurants);
}
