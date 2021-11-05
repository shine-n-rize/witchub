package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Wishlist {

    @NotNull
    private int wishlistId;

    // foreign key(s)
    private int buyerId;
    private int productId;

    public Wishlist(int wishlistId, int buyerId, int productId) {
        this.wishlistId = wishlistId;
        this.buyerId = buyerId;
        this.productId = productId;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
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
        return "Wishlist{" +
                "wishlistId=" + wishlistId +
                ", buyerId=" + buyerId +
                ", productId=" + productId +
                '}';
    }
}
