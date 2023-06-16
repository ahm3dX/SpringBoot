package TN.CompanyManagement.Controller.GestionForum;

import TN.CompanyManagement.Config.JwtRequestFilter;
import TN.CompanyManagement.Entity.Forum.Post;
import TN.CompanyManagement.Entity.User;
import TN.CompanyManagement.Service.GestionForum.IservicePost;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Post")
public class PostController {

        @Autowired
        IservicePost iSevice;
        @PostMapping("/addPost")
        public Post AddPost(@RequestBody Post post) {
                System.out.println(JwtRequestFilter.currentUser);
               post.setOwner(JwtRequestFilter.currentUser);
                return iSevice.addPost(post);
        }
        @PostMapping("/DeletePost/{idPost}")
        public ResponseEntity<String> DeletePost(@PathVariable("idPost") Integer idPost) {
                System.out.println(JwtRequestFilter.currentUser);

                return iSevice.removePost(idPost,JwtRequestFilter.currentUser);
        }
        @PostMapping("/UpdatePost/{idPost}")
        public Post AddPost(@PathVariable("idPost") Integer idPost ,@RequestBody() String content) {
                System.out.println(JwtRequestFilter.currentUser);
                Post p = iSevice.retrievePost(idPost);
                p.setQuestion(content);
                return iSevice.updatePost(p);
        }
        @GetMapping("/GetPost/{idPost}")
        public Post AddPost(@PathVariable("idPost") Integer idPost) {

                return iSevice.retrievePost(idPost);
        }


        // http://localhost:8089/Forest/Post/getBestPost
        @GetMapping("/getBestPost")
        public Post getBestPost() {

            return iSevice.getBestPost();
        }
        // http://localhost:8089/Forest/Post/GetUserPosts
        @GetMapping("/GetUserPosts")
        public List<Post> GetUserPosts(@RequestBody User user) {

                return iSevice.GetUserPosts(user);
        }
        // http://localhost:8089/Forest/Post/GetUserPosts/{id}
        @GetMapping("/GetUserPosts/{idUser}")
        public List<Post> GetUserPosts(@PathVariable("idUser") Integer idUser) {

                return iSevice.GetUserPosts(idUser);
        }
        @GetMapping("/GetMyPosts/")
        public List<Post> GetMyPosts() {

                return iSevice.GetUserPosts(JwtRequestFilter.currentUser.getUserid());
        }
        // http://localhost:8089/Forest/Post/GetUserScore/{id}
        @GetMapping("/GetUserScore/{idUser}")
        public Integer GetUserScore(@PathVariable("idUser") Integer idUser) {

                return iSevice.GetUserScore(idUser);}

        @PostMapping("/UpVotePost/{idPost}")
        public boolean UpVotePost(@PathVariable("idPost") Integer idPost) {
                Post p = iSevice.retrievePost(idPost);
               return   iSevice.Upvote(p);
        }
        @PostMapping("/DownVotePost/{idPost}")
        public boolean DownVotePost(@PathVariable("idPost") Integer idPost) {
                Post p = iSevice.retrievePost(idPost);
                return   iSevice.Downvote(p);
        }
        @GetMapping("/GetAllPosts/")
        public List<Post> GetAllPosts() {

                return iSevice.GetAllPosts();
        }
        @GetMapping("/GetFlaggedPosts/")
        public List<Post> GetFlaggedPosts() {

                return iSevice.getFlaggedPosts();
        }
}
