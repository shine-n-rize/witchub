package witchub.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import witchub.com.Utilities.FileUploadUtility;
import witchub.com.models.Product;
import witchub.com.models.Seller;
import witchub.com.models.User;
import witchub.com.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/addProduct")
//    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
//    public String addProduct(Model model){
//        model.addAttribute("user",new User());
//        model.addAttribute("seller",new Seller());
//        model.addAttribute("product", new Product());
//        System.out.println("hello");
//        return "/seller/sellerAddProduct";
//    }

//    @GetMapping("/addProduct")
//    @PostMapping("/addProduct")
    @RequestMapping(value = "/addProduct", method = {RequestMethod.GET, RequestMethod.POST})
    public String addProduct(@RequestParam("image") MultipartFile multipartFile, @Valid @ModelAttribute("product")Product product, HttpServletRequest hr, BindingResult result, SecurityContextHolderAwareRequestWrapper request, Model model) throws IOException {
        if(hr.getMethod()=="GET"){
            model.addAttribute("user",new User());
            model.addAttribute("seller",new Seller());
            model.addAttribute("product", new Product());
            System.out.println("hello");
            return "/seller/sellerAddProduct";
        }
        else {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            fileName = fileName.replaceAll("\\s", "");
            System.out.println(fileName);
            product.setImage(fileName);
            productService.addProduct(request.getRemoteUser(), product);
            System.out.println(product.toString());
            String uploadDir = "src/main/resources/static/assets/products/" + product.getProductId();
            try {
                FileUploadUtility.saveFile(uploadDir, fileName, multipartFile);
            } catch (IOException e) {
                System.out.println(e);
            }
            model.addAttribute("message", "Your product has been added!");
            return "redirect:/self";
        }
    }
}
