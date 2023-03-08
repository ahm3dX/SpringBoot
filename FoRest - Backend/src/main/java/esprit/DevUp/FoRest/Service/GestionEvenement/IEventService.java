package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Creno;
import esprit.DevUp.FoRest.Entity.Event;
import esprit.DevUp.FoRest.Entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IEventService {

    Event addEvent(Event e, int idUser);

    public Event updateEvent(Event e);

    List<Event> getAllEvents();

    Optional<Event> getEvent(int id);

    void validateAdmin(int idEvent);

    void denyAdmin(int idEvent);

//    void participateToEvent(int idUser,int idEvent);

    List<User> getParticipants(int idUser);


     String retrieveAndUpdatEventStatus() throws InterruptedException;
}

