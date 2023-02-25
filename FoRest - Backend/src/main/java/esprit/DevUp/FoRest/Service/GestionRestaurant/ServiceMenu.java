package esprit.DevUp.FoRest.Service.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.others.Menu;
import esprit.DevUp.FoRest.Repository.GestionRestaurant.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ServiceMenu implements IServiceMenu {
    @Autowired
    MenuRepository menuRepository;
    @Override
    public List<Menu> retrieveAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public Menu addMenu(Menu u) {
        return menuRepository.save(u);
    }

    @Override
    public Menu updateMenu(Menu u) {
        return menuRepository.save(u);
    }

    @Override
    public Menu retrieveMenu(Integer idmenu) {
        return menuRepository.findById(idmenu).orElse(null);
    }

    @Override
    public void removeMenu(Integer idmenu) {
        menuRepository.deleteById(idmenu);
    }
}
