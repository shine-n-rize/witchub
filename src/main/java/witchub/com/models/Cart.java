package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Cart {

    @NotNull
    private int cartId;

    private int quantity;
    private int totalPrice;

    // foreign key(s)
    private int buyerId;
    private int productId;

    public Cart(int cartId, int quantity, int totalPrice, int buyerId, int productId) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.buyerId = buyerId;
        this.productId = productId;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", buyerId=" + buyerId +
                ", productId=" + productId +
                '}';
    }
}
