package sb.security.service;

import org.springframework.stereotype.Service;
import sb.security.entity.User;
import sb.security.payload.UserModel;

@Service
public interface UserService {
    // interface methods
    User registerUser(UserModel userModel);
    void saveVerificationTokenForUser(String token, User user);
    String validateVerificationToken(String token);
}
