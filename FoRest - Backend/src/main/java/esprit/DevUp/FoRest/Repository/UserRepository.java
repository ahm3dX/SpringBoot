package esprit.DevUp.FoRest.Repository;

import esprit.DevUp.FoRest.Entity.Event;
import esprit.DevUp.FoRest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /*@Query(value = "SELECT * FROM users u WHERE u.event_id_event = :id_event",
            nativeQuery = true)
    List<User> findUserByIdEvent(int idEvent);*/
    public List<User> findAllByEvent(Event event);

}
