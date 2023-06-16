package TN.CompanyManagement.Controller.GestionForum;

import TN.CompanyManagement.Entity.Forum.Post;
import TN.CompanyManagement.Entity.User;
import TN.CompanyManagement.Service.GestionForum.ServicePost;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/Flag")
public class FlagController {
    @Autowired
    ServicePost servicePost;
    @GetMapping("/getMostFlaggedUser")
    public User getMostFlaggedUser() {

        return servicePost.mostFlaggedUsers() ;
    }
}
