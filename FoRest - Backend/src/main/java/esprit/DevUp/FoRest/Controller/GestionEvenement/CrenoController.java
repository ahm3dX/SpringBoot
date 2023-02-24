package esprit.DevUp.FoRest.Controller.GestionEvenement;


import esprit.DevUp.FoRest.Entity.Creno;
import esprit.DevUp.FoRest.Entity.Event;
import esprit.DevUp.FoRest.Repository.GestionEvenement.CrenoRepository;
import esprit.DevUp.FoRest.Repository.GestionEvenement.EventRepository;
import esprit.DevUp.FoRest.Service.GestionEvenement.ICrenoService;
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
@RequestMapping("creno")
public class CrenoController {
    @Autowired
    private ICrenoService iCrenoService;
    @Autowired
    private IEventService iEventService;

    @Autowired
    CrenoRepository crenoRepository;
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("get-crenos")
    public ResponseEntity getAllCrenos() {
        List<Creno> AllCrenos = iCrenoService.getAllCrenos();
        System.out.println(AllCrenos.size());

        return new ResponseEntity(AllCrenos, HttpStatus.ACCEPTED);

    }
    @GetMapping("get-creno/{id}")
    public ResponseEntity getCreno(@PathVariable int id) {
        System.out.println("ID"+id);

        Optional<Creno> creno = iCrenoService.getCreno(id);
        return new ResponseEntity<>(creno, HttpStatus.CREATED);

    }
    @PostMapping("addcreno/{idEvent}")
    public ResponseEntity<Creno> addCreno(@RequestBody Creno c, @PathVariable("idEvent") Integer idEvent) {

        //System.out.println("ID"+idEvent);
        //Optional<Event> event = iEventService.getEvent(idEvent);
      //  System.out.println(c);
    //   Optional<Event> e = iEventService.getEvent(idEvent.intValue());
     //   c.setEvent(event.get());
        iCrenoService.addCreno(c,idEvent);
        return new ResponseEntity<>(HttpStatus.CREATED);

        //return coursClassroomService.ajouterCoursClassroom(cc, classeId);

    }

   @GetMapping("test/{id}")
    public ResponseEntity<Optional<Event>> affecter(@PathVariable int id) {
       System.out.println("ID"+id);

       Optional<Event> event = iEventService.getEvent(id);
       return new ResponseEntity<>(event, HttpStatus.CREATED);

        //Optional<Creno> creno = iCrenoService.getCreno(id_creno);
  //      List<Creno> c1 = crenoRepository.getEventFromCreno(id_event);
    //    System.out.println("testttttttt"+c1);

//            Creno c = eventRepository.findById(id_event).map(event -> {
//                event.getCrenos().add(c1);
//                return crenoRepository.save(c1);
//            }).get();
 //       System.out.println("testttttttt"+c1);

        }


}
