package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Creno;
import esprit.DevUp.FoRest.Entity.Event;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    Event addEvent(Event e);

    List<Event> getAllEvents();

    Optional<Event> getEvent(int id);

    void validateAdmin(int idEvent);

    void denyAdmin(int idEvent);


}

