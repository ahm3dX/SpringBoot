package esprit.DevUp.FoRest.Repository.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Flag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlagRepository extends JpaRepository<Flag, Integer> {

   // List<Flag> getAllBy
}