package esprit.DevUp.FoRest.Service.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Comment;
import esprit.DevUp.FoRest.Entity.Forum.Flag;
import esprit.DevUp.FoRest.Entity.Forum.Reasons;
import esprit.DevUp.FoRest.Repository.GestionForum.CommentRepository;
import esprit.DevUp.FoRest.Repository.GestionForum.FlagRepository;
import esprit.DevUp.FoRest.Repository.GestionForum.PostRepository;
import esprit.DevUp.FoRest.Service.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        p.setParentpost(postRepository.findById(idPost).get());
        return  commentRepository.save(p);
    }

    @Override
    public Comment updateComment(Comment p) {
        return commentRepository.save(p);
    }

    @Override
    public Comment retrieveComment(Integer CommentID) {
        return commentRepository.findById(CommentID).get();
    }

    @Override
    public void removeComment(Integer CommentID) {
            commentRepository.deleteById(CommentID);
    }

    @Override
    public String detectForbiddenWords(Comment comment) {
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

            flag.setComment(comment);
            flag.setReasonType(Reasons.TooManyBadWords);
            flagRepository.save(flag);

        }
        if (i>0){
            comment.setContent(auditedContent);
            commentRepository.save(comment);
            return auditedContent;
        }else return comment.getContent();

    }




}
