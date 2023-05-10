package esprit.DevUp.FoRest.Service.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Bannings;
import esprit.DevUp.FoRest.Entity.Forum.Post;
import esprit.DevUp.FoRest.Entity.User;

import java.util.List;

public interface IservicePost {


    Post addPost (Post p);

    Post updatePost ( Post p);

    Post retrievePost( Integer postID);

    void removePost(Integer postID);

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


}
