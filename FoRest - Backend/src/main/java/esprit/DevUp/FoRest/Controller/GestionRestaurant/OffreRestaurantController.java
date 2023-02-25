package esprit.DevUp.FoRest.Controller.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.OffreRestaurant;
import esprit.DevUp.FoRest.Service.GestionRestaurant.IServiceOffreRestaurant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/offreRestaurant")
public class OffreRestaurantController {

    @Autowired
    IServiceOffreRestaurant iServiceOffreRestaurant;

    @GetMapping("/{idrestaurant}/retrieveAlloffreRestaurant")
    public List<OffreRestaurant> getoffreRestaurant(@PathVariable("idrestaurant") Integer idrestaurant) {
        List<OffreRestaurant> list = iServiceOffreRestaurant.retrieveAllROffreestaurants(idrestaurant);
        return list;
    }

    @PostMapping("/{idrestaurant}/addOffreRestaurant")
    public OffreRestaurant addOffreRestaurant(@PathVariable("idrestaurant") Integer idrestaurant,@RequestBody OffreRestaurant offreRestaurant) {
        OffreRestaurant r = iServiceOffreRestaurant.addOffreRestaurant(offreRestaurant,idrestaurant);
        return r;
    }
    @DeleteMapping("/removeOffreRestaurant/{idOffreRestaurant}")
    public void removeOffreRestaurant(@PathVariable("idOffreRestaurant") Integer idOffreRestaurant) {
        iServiceOffreRestaurant.removeOffreRestaurant(idOffreRestaurant);
    }

    @PutMapping("/updateOffreRestaurant/{idOffreRestaurant}")
    public OffreRestaurant updateOffreRestaurant(@RequestBody OffreRestaurant offre) {
        OffreRestaurant offreRestaurant= iServiceOffreRestaurant.updateOffreRestaurant(offre);
        return offreRestaurant;
    }
}
