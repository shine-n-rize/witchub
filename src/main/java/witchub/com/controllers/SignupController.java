package witchub.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import witchub.com.events.OnSignupSuccessEvent;
import witchub.com.models.User;
import witchub.com.models.VerificationToken;
import witchub.com.services.SecurityService;
import witchub.com.services.SellerService;
import witchub.com.services.UserService;

import javax.validation.Valid;
import java.util.Calendar;

@Controller
public class SignupController {
    private UserService userService;
    private SellerService sellerService;
    private SecurityService securityService;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public SignupController(UserService userService, SecurityService securityService, ApplicationEventPublisher eventPublisher, SellerService sellerService) {
        this.userService = userService;
        this.securityService = securityService;
        this.eventPublisher = eventPublisher;
        this.sellerService = sellerService;
    }

    @GetMapping({"/signup"})
    public String signup(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @GetMapping("/signupError")
    public String signupError(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("emailError",true);
        return "signup";
    }

    @GetMapping({"/accountInfo"})
    public String accountInfo(Model model){
        model.addAttribute("user", new User());
        return "accountInfo";
    }

    @PostMapping("/accountInfo")
    public String accountInfo(@RequestParam(value = "accountNo", required = true) String accountNo, Model model){
        System.out.println(accountNo);
        if(accountNo.length() < 9 || accountNo.length() > 18){
            model.addAttribute("errorMessage", "Invalid Account Number");
            return "/signup";
        }
        sellerService.save();
        return "redirect:/login";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("user") User user, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(userService.userExists(user.getEmail())){
            return "redirect:/signupError";
        }
        userService.save(user);
//        if(user.getRole().equals("4")){
//            model.addAttribute("user", user);
//            return "accountInfo";
//        }
//        System.out.println(user.getRole());
        User user1 = userService.findByUsername(user.getEmail());
        try {
            String appUrl = request.getContextPath();
            System.out.println(appUrl);
            eventPublisher.publishEvent(new OnSignupSuccessEvent(appUrl,user1));
        }catch (Exception re) {
            re.printStackTrace();
        }
//        return "verification";
        return "redirect:/login";
    }

    @GetMapping("/confirmSignup")
    public String confirmSignup(WebRequest request, Model model, @RequestParam("token") String token){
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if(verificationToken == null) {
            return "redirect:/403";
        }
        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();
        if(verificationToken.getExpiryDate().getTime()-calendar.getTime().getTime()<=0){
            return "redirect:/403";
        }
        userService.enableRegisteredUser(user);
        return "redirect:/login";
    }

}
