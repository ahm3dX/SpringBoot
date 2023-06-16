package TN.CompanyManagement.Service.GestionForum;

import TN.CompanyManagement.Entity.Forum.Bannings;
import TN.CompanyManagement.Entity.Forum.Post;
import TN.CompanyManagement.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IservicePost {


    Post addPost (Post p);

    Post updatePost ( Post p);

    Post retrievePost( Integer postID);

    ResponseEntity<String> removePost(Integer postID, User user);

    Post getBestPost();
     List<Post> GetUserPosts(User user);
    List<Post> GetUserPosts(Integer idUser);
    Integer GetUserScore(User user);
    Integer GetUserScore(Integer iduser);
    User mostActiveUser();
    List<User> topUsersOfTheMonth();
    boolean Upvote(Post p);
    boolean Downvote(Post p);
    List<Post> getFlaggedPosts();
    User mostFlaggedUsers();
    Bannings userBanStatus(User user);

    List<Post> GetAllPosts();
}
