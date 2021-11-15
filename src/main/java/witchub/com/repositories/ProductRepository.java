package witchub.com.repositories;

import witchub.com.models.Product;

public interface ProductRepository {
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void viewProduct(int ProductId);
    public void deleteProduct(int productId);
}
