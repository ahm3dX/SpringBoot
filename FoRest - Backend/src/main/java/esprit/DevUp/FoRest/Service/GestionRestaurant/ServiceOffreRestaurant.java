package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.OffreRestaurant;
import esprit.DevUp.FoRest.Entity.Restaurant;
import esprit.DevUp.FoRest.Repository.GestionRestaurant.OffreRestaurantRepository;
import esprit.DevUp.FoRest.Repository.GestionRestaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceOffreRestaurant implements IServiceOffreRestaurant {
    @Autowired
   OffreRestaurantRepository offrerestaurantRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Override
    public List<OffreRestaurant> retrieveAllROffreestaurants(Integer id) {
        System.out.println(id);
        Restaurant restaurant= restaurantRepository.findById(id).get();
        return offrerestaurantRepository.findByRestaurant(restaurant);
    }

    @Override
    public OffreRestaurant addOffreRestaurant(OffreRestaurant u,Integer id) {
        Restaurant restaurant= restaurantRepository.findById(id).get();
        u.setRestaurant(restaurant);
        return offrerestaurantRepository.save(u);
    }

    @Override
    public OffreRestaurant updateOffreRestaurant(OffreRestaurant u) {
        return offrerestaurantRepository.save(u);
    }

    @Override
    public OffreRestaurant retrieveOffreRestaurant(Integer Offreidrestaurant) {
        return offrerestaurantRepository.findById(Offreidrestaurant).orElse(null);
    }

    @Override
    public void removeOffreRestaurant(Integer idOffrerestaurant) {
        offrerestaurantRepository.deleteById(idOffrerestaurant);
    }
}
