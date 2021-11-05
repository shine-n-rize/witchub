package witchub.com.models;

public class Image {
    private String linkToImage;

    // foreign key(s)
    private int productId;

    public Image(String linkToImage, int productId) {
        this.linkToImage = linkToImage;
        this.productId = productId;
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
                "linkToImage='" + linkToImage + '\'' +
                ", productId=" + productId +
                '}';
    }
}
