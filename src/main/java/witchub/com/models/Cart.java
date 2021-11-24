package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Cart {

    @NotNull
    private int cartId;

    private int quantity;

    // foreign key(s)
    private int userId;
    private Product product;

    public Cart(int cartId, int quantity, int buyerId, Product product) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.userId = buyerId;
        this.product = product;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", quantity=" + quantity +
                ", userId=" + userId +
                ", product=" + product +
                '}';
    }
}
