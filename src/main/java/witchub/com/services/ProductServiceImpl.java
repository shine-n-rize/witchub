package witchub.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witchub.com.models.Product;
import witchub.com.models.User;
import witchub.com.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private UserService userService;
    private SellerService sellerService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserService userService, SellerService sellerService) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.sellerService = sellerService;
    }

    @Override
    public void addProduct(String username, Product product) {
        User user = userService.findByUsername(username);
        int id = sellerService.getSellerIdByUserId(user.getUserId());
        product.setSellerId(id);
        productRepository.addProduct(product);
    }
}
