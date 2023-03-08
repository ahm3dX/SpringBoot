package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.others.Menu;

import java.util.List;

public interface IServiceMenu {
    List<Menu> retrieveAllMenu();

    Menu addMenu (Menu u);

    Menu updateMenu (Menu u);

    Menu retrieveMenu(Integer idmenu);

    void removeMenu(Integer idmenu);
}
