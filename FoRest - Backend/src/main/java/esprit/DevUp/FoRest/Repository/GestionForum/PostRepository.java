package esprit.DevUp.FoRest.Repository.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "Select * From post p  Order by (p.upvotes - p.downvote) DESC LIMIT 1",nativeQuery = true)
    Post getBestPostSQL();

    @Query("select p from Post p where p.owner.userid = ?1")
    List<Post> getPostByOwner_IdUser(Integer idUser);
    List<Post> findPostByNbFlagedGreaterThan(int x);

    Post findByIdPost(int i);

}