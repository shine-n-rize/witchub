package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Category {

    @NotNull
    private int categoryId;

    private String title;

    // foreign key(s)
    private int productId;

    public Category(int categoryId, String title, int productId) {
        this.categoryId = categoryId;
        this.title = title;
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", productId=" + productId +
                '}';
    }
}
