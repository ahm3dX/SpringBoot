package esprit.DevUp.FoRest.Repository.GestionEvenement;

import esprit.DevUp.FoRest.Entity.invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepository extends JpaRepository<invite, Integer> {

}
