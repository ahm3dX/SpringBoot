package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Creno;
import esprit.DevUp.FoRest.Entity.Event;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IEventService {

    Event addEvent(Event e, int idUser);

    List<Event> getAllEvents();

    Optional<Event> getEvent(int id);

    void validateAdmin(int idEvent);

    void denyAdmin(int idEvent);


}

