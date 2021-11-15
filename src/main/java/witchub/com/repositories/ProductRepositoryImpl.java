package witchub.com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import witchub.com.Utilities.DateTimeUtility;
import witchub.com.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    JdbcTemplate jdbcTemplate;
    DateTimeUtility dateTimeUtility;

    @Autowired
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate, DateTimeUtility dateTimeUtility) {
        this.jdbcTemplate = jdbcTemplate;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public void addProduct(Product product) {
        String query = "INSERT INTO Product(seller_id, title, description, price, stock, image, date_added) VALUE (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, product.getSellerId(), product.getTitle(), product.getDescription(),product.getPrice(), product.getStock(), product.getImage(), dateTimeUtility.getCurrentDateTime("yyyy-MM-dd"));
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void viewProduct(int ProductId) {

    }

    @Override
    public void deleteProduct(int productId) {

    }
}
