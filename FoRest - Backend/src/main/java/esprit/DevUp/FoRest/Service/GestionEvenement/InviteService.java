package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.invite;
import esprit.DevUp.FoRest.Repository.GestionEvenement.InviteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

;

@Service
@AllArgsConstructor
public class InviteService implements IinviteService {
    InviteRepository inviteRepository;

    @Override
    public invite addInvite(invite i) {
        return inviteRepository.save(i);
    }

    @Override
    public List<invite> getAllInvite() {
        return inviteRepository.findAll();
    }

    @Override
    public Optional<invite> getInvite(int id) {

        return inviteRepository.findById(id);
    }
}
