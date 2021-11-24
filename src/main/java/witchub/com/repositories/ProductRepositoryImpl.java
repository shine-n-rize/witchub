package witchub.com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import witchub.com.Utilities.DateTimeUtility;
import witchub.com.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    JdbcTemplate jdbcTemplate;
    DateTimeUtility dateTimeUtility;

    @Autowired
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate, DateTimeUtility dateTimeUtility) {
        this.jdbcTemplate = jdbcTemplate;
        this.dateTimeUtility = dateTimeUtility;
    }

    private RowMapper<Product> productRowMapper = new RowMapper<Product>() {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setSellerId(rs.getInt("seller_id"));
            product.setTitle(rs.getString("title"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getInt("price"));
            product.setStock(rs.getInt("stock"));
            product.setImage(rs.getString("image"));
            product.setRating(rs.getInt("rating"));
            product.setRequested(rs.getBoolean("is_requested"));
            product.setDateAdded(rs.getDate("date_added"));
            return product;
        }
    };

    @Override
    public Product findById(int id){
        String query = "SELECT * FROM Product WHERE product_id='"+id+"'";
        return jdbcTemplate.queryForObject(query, productRowMapper);
    }

    @Override
    public List<Product> findBySeller(int sellerId){
        String query = "SELECT * FROM Product WHERE seller_id='"+sellerId+"'";
        List<Product> products = jdbcTemplate.query(query, productRowMapper);
        return products;
    }

    @Override
    public void save(Product product) {
        String query = "INSERT INTO Product(seller_id, title, description, price, stock, image, date_added) VALUE (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, product.getSellerId(), product.getTitle(), product.getDescription(),product.getPrice(), product.getStock(), product.getImage(), dateTimeUtility.getCurrentDateTime("yyyy-MM-dd"));
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public List<Product> getAllProducts() {
        String query = "SELECT * FROM Product";
        List<Product> products = jdbcTemplate.query(query, productRowMapper);
        return products;
    }

    @Override
    public void delete(int productId) {
        String query = "DELETE FROM Product WHERE product_id = "+productId;
        jdbcTemplate.update(query);
    }
}
