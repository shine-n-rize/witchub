package witchub.com.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import witchub.com.models.User;
import witchub.com.services.UserService;

import java.util.UUID;

@Component
public class SignupEmailListener {
    private MailSender mailSender;
    private UserService userService;

    @Autowired
    public SignupEmailListener(MailSender mailSender, UserService userService) {
        this.mailSender = mailSender;
        this.userService = userService;
    }

    public void onApplicationEvent(OnSignupSuccessEvent onSignupSuccessEvent) {
        this.confirmSignup(onSignupSuccessEvent);
    }

    private void confirmSignup(OnSignupSuccessEvent onSignupSuccessEvent){
        User user = onSignupSuccessEvent.getUser();
        String token = UUID.randomUUID().toString();
        userService.createVerificationToken(user,token);
        String recipient = user.getEmail();
        String subject = "Registration Confirmation";
        String url = onSignupSuccessEvent.getAppUrl() + "/confirmRegistration?token="+token;
        String message = "Thank you for registering. Please click on the below link to activate your account.";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipient);
        email.setSubject(subject);
        email.setText(message + "http://localhost:8080/" + url);
        mailSender.send(email);
    }
}
