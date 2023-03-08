package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Event.Event;
import esprit.DevUp.FoRest.Entity.User;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    Event addEvent(Event e);

    public Event updateEvent(Event e);

    List<Event> getAllEvents();

    Optional<Event> getEvent(int id);

    void validateAdmin(int idEvent);

    void denyAdmin(int idEvent);

//    void participateToEvent(int idUser,int idEvent);

    List<User> getParticipants(int idUser);


     String retrieveAndUpdatEventStatus() throws InterruptedException;
}

