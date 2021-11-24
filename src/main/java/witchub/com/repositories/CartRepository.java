package witchub.com.repositories;

import witchub.com.models.Cart;

import java.util.List;

public interface CartRepository {
    public void addProductToCart(Cart cart);
    public List<Cart> findByBuyerId(int userId);
    public Cart findById(int cartId);
    public void updateQuantity(int quantity, int cartId);
    public void delete(int cartId);
}
