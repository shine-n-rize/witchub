package witchub.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witchub.com.models.Product;
import witchub.com.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements witchub.com.services.ProductService {
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
    public List<Product> getBySeller(int sellerId){
        return productRepository.findBySeller(sellerId);
    }

    @Override
    public Product getById(int sellerId){
        return productRepository.findById(sellerId);
    }

    @Override
    public void addProduct(Product product) {
        product.setProductId(0);
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAllProducts();
    }

    @Override
    public void delete(int productId){
        productRepository.delete(productId);
    }
}
