package esprit.DevUp.FoRest.Service.EventServices;

import esprit.DevUp.FoRest.Entity.Event.*;
import esprit.DevUp.FoRest.Repository.EventRepository.*;
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
