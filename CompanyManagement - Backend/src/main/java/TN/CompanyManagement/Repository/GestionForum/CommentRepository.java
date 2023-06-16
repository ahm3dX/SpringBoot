package TN.CompanyManagement.Repository.GestionForum;

import TN.CompanyManagement.Entity.Forum.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("select c from Comment c where c.owner.userid = ?1")
    List<Comment> getCommentByOwner_IdUser(Integer iduser);
    //@EntityGraph(attributePaths = {"parentpost"})

   // List<Comment> getCommentByParentpost_IdPost(Integer idpost);
   @Query("select c from Comment c where c.parentpost.idPost = ?1")
   List<Comment> findCommentByParentpostIdPost(Integer idpost);
   Comment getByIdComment(Integer idComment);
}