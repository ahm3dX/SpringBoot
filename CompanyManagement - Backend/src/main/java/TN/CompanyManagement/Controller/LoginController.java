package TN.CompanyManagement.Controller;


import TN.CompanyManagement.Config.JwtTokenUtil;
import TN.CompanyManagement.Config.JwtRequestFilter;
import TN.CompanyManagement.Entity.AuthRequest;
import TN.CompanyManagement.Entity.User;
import TN.CompanyManagement.Service.ISeviceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    public User welcome() {
        if (JwtRequestFilter.currentUser!=null) return JwtRequestFilter.currentUser;
        return null;
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
