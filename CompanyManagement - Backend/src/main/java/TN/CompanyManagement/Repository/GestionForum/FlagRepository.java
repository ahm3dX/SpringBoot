package TN.CompanyManagement.Repository.GestionForum;

import TN.CompanyManagement.Entity.Forum.Flag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlagRepository extends JpaRepository<Flag, Integer> {

   // List<Flag> getAllBy
}