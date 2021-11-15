package witchub.com.services;

import org.springframework.ui.Model;
import witchub.com.models.Product;

public interface ProductService {
    public void addProduct(String username, Product product);
}
