package esprit.DevUp.FoRest.Controller.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.Menu;
import esprit.DevUp.FoRest.Service.GestionRestaurant.IServiceMenu;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/Menu")
public class MenuController {
    @Autowired
    IServiceMenu iserviceMenu;
    @GetMapping("/retrieveAllMenu")
    public List<Menu> getMenu() {
        List<Menu> list = iserviceMenu.retrieveAllMenu();
        return list;
    }

    @PostMapping("/addMenu/{idrestaurant}")
    public Menu addMenu(@RequestBody Menu menu,@PathVariable("idrestaurant")Integer idrestaurant) {
        Menu r = iserviceMenu.addMenu(idrestaurant,menu);
        return r;
    }

    @DeleteMapping("/removeMenu/{idMenu}")
    public void removeMenu(@PathVariable("idMenu") Integer idmenu) {
        iserviceMenu.removeMenu(idmenu);
    }

    @PutMapping("/updateMenu/{idMenu}")
    public Menu updateMenu(@RequestBody Menu idmenu) {
        Menu menu= iserviceMenu.updateMenu(idmenu);
        return idmenu;
    }
}
