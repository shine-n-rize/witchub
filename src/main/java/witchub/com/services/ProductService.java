package witchub.com.services;

import witchub.com.models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getBySeller(int sellerId);
    public Product getById(int sellerId);
    public void addProduct(Product product);
    public List<Product> getAll();
    public void delete(int productId);
}
