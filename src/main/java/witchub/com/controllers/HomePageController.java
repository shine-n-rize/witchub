package witchub.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomePageController {
    SecurityService securityService;

    @Autowired
    public HomePageController(SecurityService securityService) {
        this.securityService = securityService;
    }
}
