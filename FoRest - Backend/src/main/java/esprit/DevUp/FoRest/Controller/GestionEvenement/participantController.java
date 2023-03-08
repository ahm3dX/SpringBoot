package esprit.DevUp.FoRest.Controller.GestionEvenement;


import esprit.DevUp.FoRest.Entity.Creno;
import esprit.DevUp.FoRest.Entity.Event;
import esprit.DevUp.FoRest.Entity.invite;
import esprit.DevUp.FoRest.Entity.participant;
import esprit.DevUp.FoRest.Service.GestionEvenement.IparticipantService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("participant")
public class participantController {

    private IparticipantService iparticipantService;

    @PostMapping("UserParticipateTo/{iduser}/{idEvent}")
    @ResponseBody
    public boolean AffecterUserEvent(@RequestBody participant p, @PathVariable("iduser") Integer iduser, @PathVariable("idEvent") Integer idEvent) {

     iparticipantService.participateToEvent(p,iduser,idEvent);

        return true;
    }

    /*@GetMapping("get-participants/{id}")
   public ResponseEntity getParticipantEvent (@PathVariable int id) {
        Optional<participant> participant = iparticipantService.retrieveParticipants(id);
        return new ResponseEntity<>(participant, HttpStatus.CREATED);
    }*/

    @GetMapping("retrieve/{id}")
    public Set<participant> getParticipantEvent(@PathVariable("id") Integer id) {
        Set<participant> list = (Set<participant>) iparticipantService.retrieveParticipants(id);
        return list;
    }

    @GetMapping("get-participants")
    public ResponseEntity getAllParticipants() {


        List<participant> Allparticipants = iparticipantService.getAllParticipants();
        return new ResponseEntity<>(Allparticipants, HttpStatus.CREATED);

    }
    @GetMapping("/participant-event/{idEvent}")
    public List<participant> ParticipantsByEvent(@PathVariable("idEvent") Integer idEvent) {
        List<participant> participants = iparticipantService.getParticipantsByEvent(idEvent);
        return participants;
    }

}
