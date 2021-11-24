package witchub.com.services;

import witchub.com.models.Cart;

import java.util.List;

public interface CartService {
    public void addProductToCart(Cart cart);
    public List<Cart> getByBuyer(int userId);
    public Cart getById(int cartId);
    public void updateQuantity(int quantity, int cartId);
    public void delete(int cartId);
}
