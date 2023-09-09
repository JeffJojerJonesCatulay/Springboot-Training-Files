package sb.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import sb.security.entity.User;
import sb.security.event.RegistrationCompleteEvent;
import sb.security.payload.UserModel;
import sb.security.service.UserService;

@RestController
public class RegistrationController{
    @Autowired
    private UserService service;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = service.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "Success";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result = service.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid")){
            return "Verified";
        }
        return "Bad request";
    }

    private String applicationUrl(HttpServletRequest request){
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

}