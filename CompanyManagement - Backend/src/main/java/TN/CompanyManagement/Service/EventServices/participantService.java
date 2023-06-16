package TN.CompanyManagement.Service.EventServices;

import TN.CompanyManagement.Entity.Event.Event;
import TN.CompanyManagement.Entity.Event.participant;
import TN.CompanyManagement.Repository.EventRepository.EventRepository;
import TN.CompanyManagement.Repository.EventRepository.participantRepository;
import TN.CompanyManagement.Entity.User;

import TN.CompanyManagement.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class participantService implements IparticipantService{
    @Autowired
    participantRepository participantRepo ;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;


        @Override
        @Transactional
        public void  participateToEvent(participant p , int idUser, int idEvent) {

        User Us = userRepository.findById(idUser).get();
        p.setUsersP(Us);

        Event Ev = eventRepository.findById(idEvent).get();
        p.setEvent(Ev);

       participantRepo.save(p);
    }

   @Override
    public participant retrieveParticipants(Integer id) {
        return participantRepo.findById (id).orElse(null);
    }
    @Override
    public List<participant> getAllParticipants() {
        return participantRepo.findAll();
    }

    @Override
    public List<participant> getParticipantsByEvent(int idEvent) {
            Event event = eventRepository.findById(idEvent).get();
            return participantRepo.findByEvent(event);
    }
    /* @Override
    public List<OffreRestaurant> retrieveAllOffreByRestaurant(Integer id) {// te5ou les offre mta3 restaurant we7ed
        Restaurant restaurant= restaurantRepository.findById(id).get();
        return offrerestaurantRepository.findByRestaurant(restaurant);
    }*/


}
