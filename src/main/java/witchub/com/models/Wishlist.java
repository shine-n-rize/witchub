package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Wishlist {

    @NotNull
    private int wishlistId;

    // foreign key(s)
    private int userId;
    private int productId;

    public Wishlist(int wishlistId, int buyerId, int productId) {
        this.wishlistId = wishlistId;
        this.userId = buyerId;
        this.productId = productId;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                ", buyerId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
