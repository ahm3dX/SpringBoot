package esprit.DevUp.FoRest.Repository.GestionEvenement;


import esprit.DevUp.FoRest.Entity.Event;
import esprit.DevUp.FoRest.Entity.participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface participantRepository extends JpaRepository<participant, Integer> {
    //  List<OffreRestaurant> findByRestaurant(Restaurant restaurant);
    List<participant> findByEvent(Event event);

}
