package witchub.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import witchub.com.services.SecurityService;

@Controller
public class LogoutController {
    private SecurityService securityService;

    @Autowired
    public LogoutController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/logout")
    public String logout() {
        securityService.autoLogout();
        return "redirect:/login?logout";
    }
}
