package witchub.com.repositories;

import witchub.com.models.Product;

import java.util.List;

public interface ProductRepository {
    public Product findById(int id);
    public List<Product> findBySeller(int sellerId);
    public void save(Product product);
    public void updateProduct(Product product);
    public List<Product> getAllProducts();
    public void delete(int productId);
}
