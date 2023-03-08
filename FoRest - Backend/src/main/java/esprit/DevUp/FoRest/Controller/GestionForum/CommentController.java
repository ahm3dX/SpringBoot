package esprit.DevUp.FoRest.Controller.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Comment;
import esprit.DevUp.FoRest.Service.GestionForum.IserviceComment;
import esprit.DevUp.FoRest.Service.GestionForum.IservicePost;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/Comment")
public class CommentController {
    @Autowired
    IservicePost iservicePost;
    @Autowired
    IserviceComment iSeviceComment;
    @PostMapping("/addComment/{idPost}")
    public Comment AddComment(@RequestBody Comment comment, @PathVariable("idPost") Integer idPost) {

        return iSeviceComment.addComment(comment,idPost);
    }
}
