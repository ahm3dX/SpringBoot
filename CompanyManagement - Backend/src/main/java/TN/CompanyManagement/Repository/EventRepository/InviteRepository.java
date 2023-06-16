package TN.CompanyManagement.Repository.EventRepository;

import TN.CompanyManagement.Entity.Event.invite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepository extends JpaRepository<invite, Integer> {

}
