package esprit.DevUp.FoRest.Service.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Plannification;

import java.util.List;
import java.util.Optional;

public interface IPlannificationService {

    //    List<Plannification> retrieveAllPlannification();
    Plannification addPlan(Plannification p );

    List<Plannification> getAllPlannifications();

    Optional<Plannification> getPlannification(int id);

}

