package smb.teatar.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService serv;

    @PostMapping("/register")
    public User registerUser (@RequestParam String first_name, @RequestParam String last_name, @RequestParam String status){
        return serv.registerUser(first_name, last_name, status);
    }

}
