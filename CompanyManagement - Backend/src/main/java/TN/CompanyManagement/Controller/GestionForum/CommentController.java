package TN.CompanyManagement.Controller.GestionForum;

import TN.CompanyManagement.Entity.Forum.Comment;
import TN.CompanyManagement.Service.GestionForum.IserviceComment;
import TN.CompanyManagement.Service.GestionForum.IservicePost;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping("/GetComment/{idComment}")
    public Comment GetComment(@PathVariable("idComment") Integer idComment) {

        return iSeviceComment.retrieveComment(idComment);
    }

    @GetMapping("/GetCommentsByPost/{idPost}")
    public List<Comment> GetCommentsByPost(@PathVariable("idPost") Integer idPost) {

        return iSeviceComment.retrieveCommentByPost(idPost);
    }
    @PostMapping("/UpdateComment")
    public Comment UpdateComment(@RequestBody Comment comment) {

        return iSeviceComment.updateComment(comment);
    }
}
