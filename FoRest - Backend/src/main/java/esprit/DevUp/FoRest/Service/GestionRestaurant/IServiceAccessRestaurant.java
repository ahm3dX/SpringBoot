package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.Restaurant.accessRestaurant;

import java.io.IOException;
import java.util.List;

public interface IServiceAccessRestaurant {
    List<accessRestaurant> retrieveAllaccess();
    accessRestaurant OneAccessRestaurant(Integer idaccessRestaurant);
    List<accessRestaurant> retrieveAllAccessbyRestaurant(Integer idRestaurant);


    accessRestaurant addaccessRestaurant (accessRestaurant u,Integer iduser,Integer idoffre);

    accessRestaurant updateaccessRestaurant (accessRestaurant u);

    void removeaccessRestaurant(Integer idaccessRestaurant);
    public byte[] accessrestaurant(Integer restid) throws IOException, InterruptedException;

}
