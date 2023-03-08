package esprit.DevUp.FoRest.Controller;


import esprit.DevUp.FoRest.Config.JwtTokenUtil;
import esprit.DevUp.FoRest.Entity.AuthRequest;
import esprit.DevUp.FoRest.Entity.User;
import esprit.DevUp.FoRest.Service.ISeviceUser;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.web.servlet.AuthorizeRequestsDsl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ISeviceUser iSevice;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @GetMapping("/")
    public String welcome() {
        return "Welcome user !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception ex) {
            throw new Exception("inavalid username/password "+ex.toString());
        }
        return jwtTokenUtil.generate(authRequest.getUserName(), null);
    }

    @PostMapping("/register")
    public String adduser(@RequestBody User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        iSevice.addUser(user);
        return "";
    }
}
