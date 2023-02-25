package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.Menu;
import esprit.DevUp.FoRest.Entity.OffreRestaurant;

import java.util.List;

public interface IServiceMenu {
    List<Menu> retrieveAllMenu();

    Menu addMenu (Integer id,Menu u);

    Menu updateMenu (Menu u);

    Menu retrieveMenu(Integer idmenu);

    void removeMenu(Integer idmenu);
}
