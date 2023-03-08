package esprit.DevUp.FoRest.Controller.GestionEvenement;


import esprit.DevUp.FoRest.Entity.EmailDetails;
import esprit.DevUp.FoRest.Entity.Event;
import esprit.DevUp.FoRest.Entity.User;
import esprit.DevUp.FoRest.Repository.GestionEvenement.EventRepository;
import esprit.DevUp.FoRest.Service.GestionEvenement.IEmailService;
import esprit.DevUp.FoRest.Service.GestionEvenement.IEventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("event")
public class EventController {
    private IEventService iEventService;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private EventRepository eventRepository;


    @GetMapping("get-events")
    public ResponseEntity getAllEvents() {
        List<Event> allEvents = iEventService.getAllEvents();
        return new ResponseEntity<>(allEvents, HttpStatus.CREATED);
    }


    @GetMapping("get-event/{id}")
    public ResponseEntity getEvent(@PathVariable int id) {
        Optional<Event> event = iEventService.getEvent(id);
        return new ResponseEntity<>(event, HttpStatus.CREATED);

    }


    @PostMapping("addevent/{id}")
    public ResponseEntity<Event> addEvent(@PathVariable int id, @RequestBody Event e) {
        System.out.println(e);
        iEventService.addEvent(e, id);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("validate/{idEvent}")
    public void deny(@PathVariable int idEvent) {
        System.out.println("ID" + idEvent);
        iEventService.validateAdmin(idEvent);
    }

    @PutMapping("deny/{idEvent}")
    public void validate(@PathVariable int idEvent) {
        System.out.println("ID" + idEvent);
        iEventService.denyAdmin(idEvent);
    }


  /*  @PostMapping("sendMail/{iduser}")
    public String sendMail(@PathVariable int iduser, @RequestBody EmailDetails details) {
        String status = emailService.sendSimpleMail(iduser, details);
        return status; }*/


/*    @PostMapping("participate/{iduser}/{idEvent}")
    @ResponseBody
    public boolean AffecteEtudiant(@PathVariable("iduser") Integer iduser, @PathVariable("idEvent") Integer idEvent) {
        iEventService.participateToEvent(iduser, idEvent);
        return true;
    }*/

    @GetMapping("getParticipants/{idUser}")
    public List<User> getParticipants(@PathVariable int idUser) {
        return eventRepository.getAllusersByEvent(idUser);
    }



}
