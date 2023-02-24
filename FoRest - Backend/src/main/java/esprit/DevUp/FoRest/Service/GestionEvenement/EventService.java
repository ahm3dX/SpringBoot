package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Creno;
import esprit.DevUp.FoRest.Entity.Event;
import esprit.DevUp.FoRest.Entity.state;
import esprit.DevUp.FoRest.Repository.GestionEvenement.CrenoRepository;
import esprit.DevUp.FoRest.Repository.GestionEvenement.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

;

@Service
@AllArgsConstructor
public class EventService implements IEventService {
    EventRepository eventRepository;
    CrenoRepository crenoRepository;

    @Scheduled(fixedDelay = 60000)
    public void fixedDelayMethod() {
        System.out.println("Method with fixed delay");
    }

    @Override
    public Event addEvent(Event e) {
        e.setState(state.PENDING);
        fixedDelayMethod();
        return eventRepository.save(e);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEvent(int id) {
        return eventRepository.findById(id);
    }

    @Override
    public void validateAdmin(int idEvent) {
        Event event = eventRepository.findById(idEvent).get();
        System.out.println("before"+event.getState());
        event.setState(state.DONE);
        System.out.println("after"+event.getState());
        eventRepository.save(event);

    }


    @Override
    public void denyAdmin(int idEvent) {
        Event event = eventRepository.findById(idEvent).get();
        event.setState(state.DENIED);
        eventRepository.save(event);
    }


}
