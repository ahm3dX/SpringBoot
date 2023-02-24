package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Plannification;
import esprit.DevUp.FoRest.Repository.GestionEvenement.PlannificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

;

@Service
@AllArgsConstructor
public class PlannificationService implements IPlannificationService {

    @Autowired
    PlannificationRepository plannificationRepository;

    @Override
    public Plannification addPlan(Plannification p) {
        return plannificationRepository.save(p);
    }

    @Override
    public List<Plannification> getAllPlannifications() {
        return plannificationRepository.findAll();

    }

    @Override
    public Optional<Plannification> getPlannification(int id) {

        return plannificationRepository.findById(id);
    }
}
