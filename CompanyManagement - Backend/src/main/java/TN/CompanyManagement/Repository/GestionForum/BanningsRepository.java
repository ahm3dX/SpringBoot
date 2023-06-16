package TN.CompanyManagement.Repository.GestionForum;

import TN.CompanyManagement.Entity.Forum.Bannings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BanningsRepository extends JpaRepository<Bannings, Integer> {
    @Query("select b from Bannings b where b.user.userid = ?1")
    Bannings findBanningsByUserIdUser(Integer idUser);
}