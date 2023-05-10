package esprit.DevUp.FoRest.Service.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Comment;

import java.util.List;


public interface IserviceComment {

   // Comment addComment (Comment p);

    Comment addComment(Comment p, Integer idPost);

    Comment updateComment(Comment p);

    Comment retrieveComment( Integer CommentID);

    void removeComment(Integer CommentID);
    Comment detectForbiddenWords(Comment comment);
    public List<Comment> retrieveCommentByPost(Integer PostID);

}
