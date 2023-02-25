package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.others.accessRestaurant;

import java.util.List;

public interface IServiceAccessRestaurant {
    List<accessRestaurant> retrieveAllaccessRestaurant();

    accessRestaurant addaccessRestaurant (accessRestaurant u);

    accessRestaurant updateaccessRestaurant (accessRestaurant u);

    accessRestaurant retrieveaccessRestaurant(Integer idaccessRestaurant);

    void removeaccessRestaurant(Integer idaccessRestaurant);
}
