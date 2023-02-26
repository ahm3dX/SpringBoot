package esprit.DevUp.FoRest.Controller.GestionEvenement;


import esprit.DevUp.FoRest.Entity.EmailDetails;
import esprit.DevUp.FoRest.Entity.Event;
import esprit.DevUp.FoRest.Service.GestionEvenement.IEmailService;
import esprit.DevUp.FoRest.Service.GestionEvenement.IEventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("event")
public class EventController {
    private IEventService iEventService;
    @Autowired
    private IEmailService emailService;


    @GetMapping("get-events")
    public ResponseEntity getAllEvents() {


        List<Event> allEvents = iEventService.getAllEvents();
        return new ResponseEntity<>(allEvents, HttpStatus.CREATED);

    }

    @GetMapping("get-event/{id}")
    public ResponseEntity getEvent(@PathVariable int id) {
        System.out.println("ID" + id);

        Optional<Event> event = iEventService.getEvent(id);
        return new ResponseEntity<>(event, HttpStatus.CREATED);

    }

    @PostMapping("addevent")
    public ResponseEntity<Event> addEvent(@RequestBody Event e) {
        System.out.println(e);
        iEventService.addEvent(e);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("validate/{idEvent}")
    public void Validate(@PathVariable int idEvent) {
        System.out.println("ID" + idEvent);
        iEventService.validateAdmin(idEvent);
    }


    @PutMapping("validate/{idEvent}")
    public void deny(@PathVariable int idEvent) {
        System.out.println("ID" + idEvent);
        iEventService.validateAdmin(idEvent);
    }


    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status
                = emailService.sendSimpleMail(details);

        return status;
    }


}
