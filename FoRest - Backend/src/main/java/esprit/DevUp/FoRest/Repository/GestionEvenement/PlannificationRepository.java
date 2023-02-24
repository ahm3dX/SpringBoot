package esprit.DevUp.FoRest.Repository.GestionEvenement;

import esprit.DevUp.FoRest.Entity.Plannification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannificationRepository extends JpaRepository<Plannification, Integer> {

}
