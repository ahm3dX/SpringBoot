package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.OffreRestaurant;

import java.util.List;

public interface IServiceOffreRestaurant {
    List<OffreRestaurant> retrieveAllROffreestaurants(Integer id);

    OffreRestaurant addOffreRestaurant (OffreRestaurant u,Integer id);

    OffreRestaurant updateOffreRestaurant (OffreRestaurant u);

    OffreRestaurant retrieveOffreRestaurant(Integer Offreidrestaurant);

    void removeOffreRestaurant(Integer idOffrerestaurant);
}
