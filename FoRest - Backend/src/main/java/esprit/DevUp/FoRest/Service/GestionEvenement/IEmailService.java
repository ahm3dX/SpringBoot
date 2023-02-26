package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.EmailDetails;

public interface IEmailService {
    String sendSimpleMail(EmailDetails details);


}
