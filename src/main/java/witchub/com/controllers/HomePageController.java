package witchub.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import witchub.com.services.SecurityService;

@Controller
public class HomePageController {
    SecurityService securityService;

    @Autowired
    public HomePageController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @RequestMapping("/403")
    public String accessDenied(){
        return "accessDenied";
    }

    @RequestMapping({"/", "", "/homepage"})
    public String homepage(Model model){
        String loggedInUsername = securityService.findLoggedInUsername();
        if(loggedInUsername==null){
            model.addAttribute("loginStatus", false);
        }
        else{
            model.addAttribute("loginStatus", true);
        }
        return "homepage";
    }
}
