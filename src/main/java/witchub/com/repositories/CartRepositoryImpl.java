package witchub.com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import witchub.com.models.Cart;
import witchub.com.models.Product;
import witchub.com.services.ProductService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository{
    JdbcTemplate jdbcTemplate;
    ProductService productService;

    @Autowired
    public CartRepositoryImpl(JdbcTemplate jdbcTemplate, ProductService productService) {
        this.jdbcTemplate = jdbcTemplate;
        this.productService = productService;
    }

    private RowMapper<Cart> cartRowMapper = new RowMapper<Cart>() {
        @Override
        public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cart(rs.getInt("cart_id"),rs.getInt("quantity"), rs.getInt("user_id"), productService.getById(rs.getInt("product_id")));
        }
    };

    @Override
    public void addProductToCart(Cart cart) {
        String query = "INSERT INTO Cart(user_id, product_id, quantity) VALUES(?, ?, ?)";
        jdbcTemplate.update(query, cart.getUserId(), cart.getProduct().getProductId(), cart.getQuantity());
    }

    @Override
    public List<Cart> findByBuyerId(int userId) {
        String query = "SELECT * FROM Cart WHERE user_id = '"+userId+"'";
        List<Cart> cartProducts = jdbcTemplate.query(query, cartRowMapper);
        return cartProducts;
    }

    @Override
    public Cart findById(int cartId){
        String query = "SELECT * FROM Cart WHERE cart_id = '"+cartId+"'";
        Cart cart = jdbcTemplate.queryForObject(query, cartRowMapper);
        return cart;
    }

    @Override
    public void updateQuantity(int quantity, int cartId) {
        String query = "UPDATE Cart SET quantity = "+quantity+" WHERE cart_id = '"+cartId+"'";
        jdbcTemplate.update(query);
    }

    @Override
    public void delete(int cartId) {
        String query = "DELETE FROM Cart WHERE cart_id = "+cartId;
        jdbcTemplate.update(query);
    }
}
