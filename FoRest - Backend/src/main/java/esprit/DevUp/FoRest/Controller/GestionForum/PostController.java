package esprit.DevUp.FoRest.Controller.GestionForum;

import esprit.DevUp.FoRest.Config.JwtRequestFilter;
import esprit.DevUp.FoRest.Entity.Forum.Post;
import esprit.DevUp.FoRest.Entity.User;
import esprit.DevUp.FoRest.Service.GestionForum.IservicePost;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
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
        // http://localhost:8089/Forest/Post/GetUserScore/{id}
        @GetMapping("/GetUserScore/{idUser}")
        public Integer GetUserScore(@PathVariable("idUser") Integer idUser) {

                return iSevice.GetUserScore(idUser);}
}
