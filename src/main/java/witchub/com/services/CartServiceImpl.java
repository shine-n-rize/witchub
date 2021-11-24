package witchub.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witchub.com.models.Cart;
import witchub.com.repositories.CartRepository;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void addProductToCart(Cart cart) {
        cartRepository.addProductToCart(cart);
    }

    @Override
    public List<Cart> getByBuyer(int userId) {
        return cartRepository.findByBuyerId(userId);
    }

    @Override
    public Cart getById(int cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public void updateQuantity(int quantity, int cartId) {
        cartRepository.updateQuantity(quantity, cartId);
    }

    @Override
    public void delete(int cartId) {
        cartRepository.delete(cartId);
    }
}
