package TN.CompanyManagement.Repository.EventRepository;



import TN.CompanyManagement.Entity.Event.Event;
import TN.CompanyManagement.Entity.Event.participant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface participantRepository extends JpaRepository<participant, Integer> {
    //  List<OffreRestaurant> findByRestaurant(Restaurant restaurant);
    List<participant> findByEvent(Event event);

}
