package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Image {

    @NotNull
    private int imageId;

    private String linkToImage;

    // foreign key(s)
    private int productId;

    public Image(int imageId, String linkToImage, int productId) {
        this.imageId = imageId;
        this.linkToImage = linkToImage;
        this.productId = productId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getLinkToImage() {
        return linkToImage;
    }

    public void setLinkToImage(String linkToImage) {
        this.linkToImage = linkToImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", linkToImage='" + linkToImage + '\'' +
                ", productId=" + productId +
                '}';
    }
}
