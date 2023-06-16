package TN.CompanyManagement.Service.GestionForum;

import TN.CompanyManagement.Config.JwtRequestFilter;
import TN.CompanyManagement.Entity.Forum.Comment;
import TN.CompanyManagement.Entity.Forum.Flag;
import TN.CompanyManagement.Entity.Forum.Reasons;
import TN.CompanyManagement.Repository.GestionForum.CommentRepository;
import TN.CompanyManagement.Repository.GestionForum.FlagRepository;
import TN.CompanyManagement.Repository.GestionForum.PostRepository;
import TN.CompanyManagement.Service.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceComment  implements IserviceComment{
    @Autowired
    ServiceUser serviceUser;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    FlagRepository flagRepository;

    @Override
    public Comment addComment(Comment p, Integer idPost) {

        p.setParentpost(postRepository.findByIdPost(idPost));
        p.setOwner(JwtRequestFilter.currentUser);
        return  detectForbiddenWords(p);
    }

    @Override
    public Comment updateComment(Comment p) {
        Comment c = commentRepository.findById(p.getIdComment()).get();
        c.setContent(p.getContent());
        return detectForbiddenWords(c);
    }

    @Override
    public Comment retrieveComment(Integer CommentID) {
        return commentRepository.findById(CommentID).get();
    }
    @Override
    public List<Comment>  retrieveCommentByPost(Integer PostID) {
        return commentRepository.findCommentByParentpostIdPost(PostID);
    }

    @Override
    public void removeComment(Integer CommentID) {
            commentRepository.deleteById(CommentID);
    }

    @Override
    public Comment detectForbiddenWords(Comment comment) {
        String[] splited = comment.getContent().split("\\s+");
        String[] badwords = new String[]{"bhim", "bouhali"};
        String auditedContent="";
        int i =0;
        for (String word:splited
             ) {
            for (String badword:badwords
                 ) {
                if(word.equals(badword)){
                    word="****";
                    i++;
            }

            }
            auditedContent=auditedContent + word;
        }
        if (i>2){  Flag flag=new Flag() ;
            comment=commentRepository.save(comment);
            flag.setComment(comment);
            flag.setReasonType(Reasons.TooManyBadWords);
            flag.setAutoFlag(true);
            flagRepository.save(flag);
            comment.setGotFlagged(true);
            return comment;
        }
        if (i>0){
            comment.setContent(auditedContent);
            commentRepository.save(comment);
            return comment;
        }else {
            commentRepository.save(comment);
            return comment;}

    }




}
