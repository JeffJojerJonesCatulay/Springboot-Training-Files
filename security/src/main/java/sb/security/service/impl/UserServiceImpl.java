package sb.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sb.security.entity.User;
import sb.security.entity.VerificationToken;
import sb.security.payload.UserModel;
import sb.security.repository.UserRepository;
import sb.security.repository.VerificationTokenRepository;
import sb.security.service.UserService;

import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private VerificationTokenRepository verificationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // implement method
    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        repository.save(user);
        return user;
    }

    public void saveVerificationTokenForUser(String token, User user){
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationRepository.save(verificationToken);
    }

    public String validateVerificationToken(String token){
        VerificationToken verificationToken = verificationRepository.findByToken(token);
        if (verificationToken == null) {
            return "Invalid";
        }
        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();
        if (verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime() <= 0){
            verificationRepository.delete(verificationToken);
            return "Expired";
        }
        user.setEnable(true);
        repository.save(user);
        return "Valid";
    }
}