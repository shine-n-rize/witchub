package witchub.com.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Product {

    @NotNull
    private int productId;

    @NotEmpty
    private String title;

    private String description;

//    @NotEmpty
    @Min(0)
    private int price;

//    @NotEmpty
    @Min(1)
    private int stock;

    @NotEmpty
    private String image;

    private float rating;
    private boolean isRequested;
    private Date dateAdded;

    // foreign key(s)
    private int sellerId;

//    public Product(int productId, String title, String description, int price, int stock, float rating, boolean isRequested, Date dateAdded, int sellerId) {
//        this.productId = productId;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.stock = stock;
//        this.rating = rating;
//        this.isRequested = isRequested;
//        this.dateAdded = dateAdded;
//        this.sellerId = sellerId;
//    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isRequested() {
        return isRequested;
    }

    public void setRequested(boolean requested) {
        isRequested = requested;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", image='" + image +
                ", rating=" + rating +
                ", isRequested=" + isRequested +
                ", dateAdded=" + dateAdded +
                ", sellerId=" + sellerId +
                '}';
    }
}
