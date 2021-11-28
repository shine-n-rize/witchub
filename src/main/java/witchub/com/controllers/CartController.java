package witchub.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import witchub.com.models.Cart;
import witchub.com.models.Product;
import witchub.com.models.User;
import witchub.com.services.CartService;
import witchub.com.services.SecurityService;
import witchub.com.services.UserService;

import java.util.List;

@Controller
public class CartController {
    SecurityService securityService;
    UserService userService;
    CartService cartService;
    witchub.com.services.ProductService productService;

    @Autowired
    public CartController(SecurityService securityService, UserService userService, CartService cartService, witchub.com.services.ProductService productService) {
        this.securityService = securityService;
        this.userService = userService;
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/cart/addProduct")
    public String addProductToCart(@RequestParam int productId, SecurityContextHolderAwareRequestWrapper request, Model model, RedirectAttributes attributes){
        String loggedInUsername = securityService.findLoggedInUsername();
        if(loggedInUsername==null){
            return "redirect:/login";
        }
        model.addAttribute("loginStatus", true);
//        System.out.println("1234");
        User user = userService.findByUsername(loggedInUsername);
//        System.out.println("678");
        List<Cart> cartList = cartService.getByBuyer(user.getUserId());
//        System.out.println("910");
        Product product = productService.getById(productId);
//        System.out.println("lalaa");
        Cart cart = new Cart(1, 1, user.getUserId(), product);
        cartService.addProductToCart(cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        String loggedInUsername = securityService.findLoggedInUsername();
        if(loggedInUsername==null){
            return "redirect:/login";
        }
        model.addAttribute("loginStatus", true);
        User user = userService.findByUsername(loggedInUsername);
        List<Cart> cartList = cartService.getByBuyer(user.getUserId());
        model.addAttribute("cartList", cartList);
        int total = 0;
        for(int i=0; i<cartList.size(); i++){
            total += cartList.get(i).getProduct().getPrice() * cartList.get(i).getQuantity();
        }
        System.out.println(total);
        model.addAttribute("totalPrice", total);
        return "buyer/cart";
    }

    @GetMapping("/cart/updateQuantity")
    public String addQuantity(@RequestParam int cartId, @RequestParam int quantity){
        if(quantity<0){
            cartService.updateQuantity(0, cartId);
        }
        else{
            cartService.updateQuantity(quantity, cartId);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/delete")
    public String delete(@RequestParam int cartId){
        cartService.delete(cartId);
        return "redirect:/cart";
    }
}
