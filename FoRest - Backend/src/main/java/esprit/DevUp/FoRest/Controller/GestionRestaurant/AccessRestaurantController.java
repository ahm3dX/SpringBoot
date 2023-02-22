package esprit.DevUp.FoRest.Controller.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.accessRestaurant;
import esprit.DevUp.FoRest.Service.GestionRestaurant.IServiceAccessRestaurant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/accessRestaurant")
public class AccessRestaurantController {
    @Autowired
    IServiceAccessRestaurant serviceAccessRestaurant;
    @GetMapping("/retrieveAllaccessRestaurant")
    public List<accessRestaurant> getaccessRestaurant() {
        List<accessRestaurant> list = serviceAccessRestaurant.retrieveAllaccessRestaurant();
        return list;
    }
    @PostMapping("/addaccessRestaurant/{iduser}/{idoffre}")
    public accessRestaurant addaccessRestaurant(@RequestBody accessRestaurant accessRestaurant,
                                                @PathVariable("iduser") Integer iduser,
                                                @PathVariable("idoffre") Integer idoffre) {
        accessRestaurant r = serviceAccessRestaurant.addaccessRestaurant(accessRestaurant,iduser,idoffre);
        return r;
    }

    @DeleteMapping("/removeaccessRestaurant/{idaccessRestaurant}")
    public void removeaccessRestaurant(@PathVariable("idaccessRestaurant") Integer idaccessRestaurant) {
        serviceAccessRestaurant.removeaccessRestaurant(idaccessRestaurant);
    }

    @PutMapping("/updateaccessRestaurant/{idaccessRestaurant}")
    public accessRestaurant updateaccessRestaurant(@RequestBody accessRestaurant idAccessRestaurant) {
        accessRestaurant accessRestaurant= serviceAccessRestaurant.updateaccessRestaurant(idAccessRestaurant);
        return accessRestaurant;
    }
}
