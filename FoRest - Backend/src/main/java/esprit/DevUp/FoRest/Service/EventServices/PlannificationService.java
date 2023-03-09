package esprit.DevUp.FoRest.Service.EventServices;

import esprit.DevUp.FoRest.Entity.Event.*;

import esprit.DevUp.FoRest.Repository.EventRepository.*;
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
    private final CrenoRepository crenoRepository;

       @Override
        public Plannification addPlan(Plannification p, Integer idCreno) {


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
