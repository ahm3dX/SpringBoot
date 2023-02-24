package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Event;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    //    List<Universite> retrieveAllUniversites();
    Event addEvent(Event e); // ajouter l’équipe avec son détail
    List<Event> getAllEvents();
    Optional<Event> getEvent(int id);

//    Universite updateUniversite (Universite e);
//    Universite retrieveUniversite (Integer idUniversite);
//    void assignUniversiteToDepartement(Integer IdUniversite, Integer IdDepartement);
}

