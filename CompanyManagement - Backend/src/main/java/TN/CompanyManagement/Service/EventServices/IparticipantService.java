package TN.CompanyManagement.Service.EventServices;

import TN.CompanyManagement.Entity.Event.participant;

import java.util.List;

public interface IparticipantService {

    public void participateToEvent(participant p , int idUser, int idEvent);

    public participant retrieveParticipants(Integer id);
    public List<participant> getAllParticipants();
    public List<participant> getParticipantsByEvent(int idEvent);
}
