package TN.CompanyManagement.Service.GestionForum;

import TN.CompanyManagement.Entity.Forum.*;

import TN.CompanyManagement.Entity.TypeUser;
import TN.CompanyManagement.Entity.User;
import TN.CompanyManagement.Repository.GestionForum.BanningsRepository;
import TN.CompanyManagement.Repository.GestionForum.CommentRepository;
import TN.CompanyManagement.Repository.GestionForum.FlagRepository;
import TN.CompanyManagement.Repository.GestionForum.PostRepository;
import TN.CompanyManagement.Service.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ServicePost implements IservicePost{
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    FlagRepository flagRepository;
    @Autowired
    BanningsRepository banningsRepository;
    @Autowired
    ServiceUser serviceUser;
    @Override
    public Post addPost(Post p) {

        return detectForbiddenWords(p);
    }

    @Override
    public Post updatePost(Post p) {
        return postRepository.save(p);
    }

    @Override
    public Post retrievePost(Integer postID) {
        return postRepository.findByIdPost(postID);

    }

    @Override
    public ResponseEntity<String> removePost(Integer postID, User user) {
        Post p = retrievePost(postID);
        if(user.equals(p.getOwner()) || user.getTypeUser().equals(TypeUser.Admin)){
        postRepository.deleteById(postID);
            return new ResponseEntity<>("Deleted post with ID:" + postID, HttpStatus.OK);
        } else { return new ResponseEntity<>("Not authorized", HttpStatus.FORBIDDEN);}

    }


    @Override
    public Post getBestPost() {


        return postRepository.getBestPostSQL();
    }

    @Transient
    public List<Post> GetUserPosts(User user) {
        System.out.println("space 1");
        return postRepository.getPostByOwner_IdUser(user.getUserid());

    }

    @Transient
    public List<Post> GetUserPosts(Integer idUser) {
        System.out.println(idUser);
        List<Post> p = postRepository.getPostByOwner_IdUser(idUser);
        System.out.println(p.size());
        return p;
                }

    @Override
    public Integer GetUserScore(User user) {

        return GetUserScore(user.getUserid());
    }
    @Transient
    public Integer GetUserScore(Integer iduser) {
        int score = 0;
        for (Post p:GetUserPosts(iduser)
             ) {
            score = score + p.getscore();
            System.out.println(/*p.getComment().size() +*/" /  /"+ score );
          //  System.out.println(p.getComments().size() +' '+ score );
           for (Comment c:commentRepository.findCommentByParentpostIdPost(p.getIdPost())
                 ) {
                if(!(c.getOwner().getUserid().equals(iduser))) score = score + c.getUpvotes();
            }

        }
        for (Comment c:commentRepository.getCommentByOwner_IdUser(iduser)
             ) {
            System.out.println(c.getUpvotes());
            score = score + c.getscore();
        }

        return score;
    }
    // a3tik akthar wa7ed habat post w comments in this month
    @Override
    public User mostActiveUser() {
        return null;
    }
    //hathi ya sayed rahi tet5dem acanci ki tjib comments w post w score mta3 fi month hatha w tzidhom 9adach active w tejma3 w ta3TI
    // a7san user fihom , ps: use design thinking methode to make it calculate for one user in the month than just make this methode loop
    // on all users and give the max or the best 5 for exemples when you give it int of 5 as param
    @Override
    public List<User> topUsersOfTheMonth() {
        return null;
    }

    @Override
    public boolean Upvote(Post p) {
        try {
            p.setUpvotes(p.getUpvotes()+1);
            postRepository.save(p);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean Downvote(Post p) {
        p.setDownvote(p.getDownvote()+1);
        postRepository.save(p);

        return false;
    }

    @Override
    public List<Post> getFlaggedPosts() {
        return postRepository.findPostByNbFlagedGreaterThan(0);
    }

    @Override
    public User mostFlaggedUsers() {
        List<Flag> flags = flagRepository.findAll();
        HashMap<Integer,Integer> nbflagperuser = new HashMap<>();
        if (flags.isEmpty()) {
            return null;
        }
        for (Flag flag:flags
             ) { if(flag.getPost()!=null)
            nbflagperuser.put(flag.getPost().getOwner().getUserid(),
                    nbflagperuser.getOrDefault(flag.getPost().getOwner().getUserid(),0)+1);
            if(flag.getComment()!=null)nbflagperuser.put(flag.getComment().getOwner().getUserid(),
                    nbflagperuser.getOrDefault(flag.getComment().getOwner().getUserid(),0)+1);
        }


        Map.Entry<Integer, Integer> integerIntegerEntry = nbflagperuser.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get();
        System.out.println(integerIntegerEntry);
        return serviceUser.retrieveUser(integerIntegerEntry.getKey());
    }

    @Override
    public Bannings userBanStatus(User user) {
        return banningsRepository.findBanningsByUserIdUser(user.getUserid()) ;
    }

    public Post detectForbiddenWords(Post comment) {
        String[] splited = comment.getQuestion().split("\\s+");
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
            comment = postRepository.save(comment);
            flag.setPost(comment);
            flag.setReasonType(Reasons.TooManyBadWords);
            flag.setAutoFlag(true);
            flagRepository.save(flag);

            return comment;
        }
        if (i>0){
            comment.setQuestion(auditedContent);
            postRepository.save(comment);
            return comment;
        }else {
            postRepository.save(comment);
            return comment;}

    }
    @Transient
    public List<Post> GetAllPosts() {

        List<Post> p = postRepository.findPostByNbFlagedLessThan(1);
        System.out.println(p.size());
        return p;
    }
}
