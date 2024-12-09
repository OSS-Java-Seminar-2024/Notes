package smb.teatar.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserRepo repo;

    public User registerUser(String first_name, String last_name, String status) {
        User user = new User();
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setStatus(status);
        return repo.save(user);
    }
}
