package esprit.DevUp.FoRest.Controller.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.Restaurant;
import esprit.DevUp.FoRest.Service.GestionRestaurant.IServiceRestaurant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/Restaurant")
public class RestaurantController {

    @Autowired
    IServiceRestaurant serviceRestaurant;

    @GetMapping("/retrieveAllRestaurant")
    public List<Restaurant> getRestaurants() {
        List<Restaurant> list = serviceRestaurant.retrieveAllRestaurants();
        return list;
    }

    @PostMapping("/addRestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant r = serviceRestaurant.addRestaurant(restaurant);
        return r;
    }
    @DeleteMapping("/removeRestaurant/{restaurantid}")
    public void removeEtudiant(@PathVariable("restaurantid") Integer idrestaurant) {
        serviceRestaurant.removeRestaurant(idrestaurant);
    }

    @PutMapping("/updaterestaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant Restaurants= serviceRestaurant.updateRestaurant(restaurant);
        return Restaurants;
    }

}
