package witchub.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

//    @GetMapping("/profileUpdated")
//    public String profileUpdated(){
//        return "/seller/sellerProfileUpdated";
//    }
//
//    @PostMapping("/profile")
//    public String profile(){
//        return "redirect:/profileUpdated";
//    }

    @GetMapping("/self/product/addSuccess")
    public String addProductSuccess(){
        return "seller/sellerAddProductSuccess";
    }

//    @PostMapping("/addProduct")
//    public String addProduct(){
//        return "redirect:/addProductSuccess";
//    }
//
//    @GetMapping("/gallery")
//    public String gallery(){
//        return "gallery";
//    }
//
    @GetMapping("/buyerProfile")
    public String buyerProfile(){
        return "/buyer/buyerProfile";
    }
//
//    @PostMapping("/buyerProfile")
//    public String buyerProfileSave(){
//        return "redirect:/buyerProfileUpdated";
//    }
//
//    @GetMapping("/buyerProfileUpdated")
//    public String buyerProfileUpdated(){
//        return "/buyer/buyerProfileUpdated";
//    }
//
//    @GetMapping("/cart")
//    public String cart(){
//        return "buyer/cart";
//    }

    @GetMapping("/order")
    public String order(){
        return "buyer/order";
    }

    @GetMapping("/orderSuccess")
    public String orderSuccess(){
        return "buyer/orderSuccess";
    }
}
