package witchub.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import witchub.com.models.Product;
import witchub.com.models.Seller;
import witchub.com.models.User;

import javax.validation.Valid;

@Controller
public class SellerController {

    @GetMapping("/profile")
    public String profile(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("seller",new Seller());
        return "/seller/sellerProfile";
    }

//    @PostMapping("/addProduct")
//    public String addProduct(@Valid @ModelAttribute("product")Product product, Model model){
//        return "redirect:/self";
//    }
}
