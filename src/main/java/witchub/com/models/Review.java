package witchub.com.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Review {

    @NotNull
    private int reviewId;

    @NotEmpty
    private int rating;     // rate from 5 stars

    private String comment;

    // foreign key(s)
    private int buyerId;
    private int productId;

    public Review(int reviewId, int rating, String comment, int buyerId, int productId) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.buyerId = buyerId;
        this.productId = productId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        return "Review{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", buyerId=" + buyerId +
                ", productId=" + productId +
                '}';
    }
}
