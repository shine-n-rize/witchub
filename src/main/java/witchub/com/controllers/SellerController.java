package witchub.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import witchub.com.models.Product;
import witchub.com.models.Seller;
import witchub.com.models.User;
import witchub.com.services.*;

import java.util.List;

@Controller
public class SellerController {
    UserService userService;
    SecurityService securityService;
    SellerService sellerService;

    @Autowired
    public SellerController(UserService userService, SecurityService securityService, SellerService sellerService, StorageService storageService, witchub.com.services.ProductService productService) {
        this.userService = userService;
        this.securityService = securityService;
        this.sellerService = sellerService;
        this.storageService = storageService;
        this.productService = productService;
    }

    StorageService storageService;
    witchub.com.services.ProductService productService;

    @RequestMapping("/self")
    public String profilePage(Model model){
        System.out.println("logged in");
        String loggedInUsername = securityService.findLoggedInUsername();
        System.out.println(loggedInUsername);
        if(loggedInUsername==null){
            return "redirect:/login";
        }
        model.addAttribute("loginStatus", true);
        User user = userService.findByUsername(loggedInUsername);
        Seller seller = sellerService.getBySellerId(user.getUserId());
        user.toString();
        model.addAttribute("user", user);
        return "seller/profile";
    }

    @RequestMapping("/self/gallery")
    public String gallery(Model model){
        String loggedInUsername = securityService.findLoggedInUsername();
        if(loggedInUsername==null){
            return "redirect:/login";
        }
        model.addAttribute("loginStatus", true);
        User user = userService.findByUsername(loggedInUsername);
        List<Product> products = productService.getBySeller(user.getUserId());
        model.addAttribute("products", products);
        return "seller/gallery";
    }

    @GetMapping({"/self/product/add"})
    public String addProduct(Model model){
        String loggedInUsername = securityService.findLoggedInUsername();
        if(loggedInUsername==null){
            return "redirect:/login";
        }
        model.addAttribute("loginStatus", true);
        model.addAttribute("product", new Product());
        return "seller/addProduct";
    }

    @PostMapping({"/self/product/add"})
    public String addProduct(@RequestParam("image") MultipartFile image, @ModelAttribute("product") Product product, BindingResult result, Model model){
        String loggedInUsername = securityService.findLoggedInUsername();
        if(loggedInUsername==null){
            return "redirect:/login";
        }
        if(image.isEmpty() || product.getTitle()==null){
            model.addAttribute("link", "/self/product/add");
            return "seller/formFailure";
        }
        storageService.uploadFile(image, loggedInUsername);
        User user = userService.findByUsername(loggedInUsername);
        product.setSellerId(user.getUserId());
//        System.out.println("controller: "+image);
//        System.out.println("before set: "+product.getImage());
        product.setImage(storageService.getUploadLocation(image, loggedInUsername));
//        System.out.println("setImage: "+ product.getImage());
        productService.addProduct(product);
        return "redirect:/self/product";
    }

    @GetMapping({"/self/product/delete"})
    public String delete(@RequestParam int productId){
        productService.delete(productId);
        return "redirect:/self/gallery";
    }
}
