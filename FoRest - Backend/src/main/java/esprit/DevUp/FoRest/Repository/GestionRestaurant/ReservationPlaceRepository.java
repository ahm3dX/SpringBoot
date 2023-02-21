package esprit.DevUp.FoRest.Repository.GestionRestaurant;

import esprit.DevUp.FoRest.Entity.ReservationPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationPlaceRepository extends JpaRepository<ReservationPlace ,Integer> {
}
