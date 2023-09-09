package sb.security.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sb.security.entity.User;
import sb.security.event.RegistrationCompleteEvent;
import sb.security.service.UserService;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    // OVERRIDE THE METHOD
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event){
        // create verification token
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        userService.saveVerificationTokenForUser(token, user);

        // log
        log.info("Click the link to verify your account: {}", url);
    }
}