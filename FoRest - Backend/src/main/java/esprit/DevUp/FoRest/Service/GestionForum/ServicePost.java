package esprit.DevUp.FoRest.Service.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Bannings;
import esprit.DevUp.FoRest.Entity.Forum.Comment;
import esprit.DevUp.FoRest.Entity.Forum.Flag;
import esprit.DevUp.FoRest.Entity.Forum.Post;
import esprit.DevUp.FoRest.Entity.User;
import esprit.DevUp.FoRest.Repository.GestionForum.BanningsRepository;
import esprit.DevUp.FoRest.Repository.GestionForum.CommentRepository;
import esprit.DevUp.FoRest.Repository.GestionForum.FlagRepository;
import esprit.DevUp.FoRest.Repository.GestionForum.PostRepository;
import esprit.DevUp.FoRest.Service.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
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

        return postRepository.save(p);
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
    public void removePost(Integer postID) {
        postRepository.deleteById(postID);
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
        Integer score = 0;
        for (Post p:GetUserPosts(iduser)
             ) {
            score = score + p.getscore();
            System.out.println(/*p.getComment().size() +*/" /  /"+ score );
          //  System.out.println(p.getComments().size() +' '+ score );
           for (Comment c:commentRepository.findCommentByParentpostIdPost(p.getIdPost())
                 ) {
                if(!(c.getOwner().getUserid()==iduser)) score = score + c.getUpvotes();
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
        if (flags !=null){
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
        return null;
    }

    @Override
    public Bannings userBanStatus(User user) {
        return banningsRepository.findBanningsByUserIdUser(user.getUserid()) ;
    }
}
