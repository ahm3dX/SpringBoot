package esprit.DevUp.FoRest.Repository.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.Restaurant.TableRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TableRepository extends JpaRepository<TableRestaurant ,Integer> {

    List<TableRestaurant> findAllByRestoIdRestaurant(Integer idRestaurant);

}
