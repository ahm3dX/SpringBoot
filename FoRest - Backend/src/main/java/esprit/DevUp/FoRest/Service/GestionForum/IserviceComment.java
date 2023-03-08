package esprit.DevUp.FoRest.Service.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Comment;


public interface IserviceComment {

   // Comment addComment (Comment p);

    Comment addComment(Comment p, Integer idPost);

    Comment updateComment(Comment p);

    Comment retrieveComment( Integer CommentID);

    void removeComment(Integer CommentID);
    String detectForbiddenWords(Comment comment);
}
