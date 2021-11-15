package witchub.com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import witchub.com.models.Seller;

@Repository
public class SellerRepositoryImpl implements SellerRepository{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public SellerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(int userId, String accountNo){
        String query = "INSERT INTO Seller(userId,accountNo) values(?,?)";
        jdbcTemplate.update(query, userId, accountNo);
    }

    @Override
    public int getSellerIdByUserId(int userId) {
        String query = "SELECT seller_id FROM Seller WHERE user_id = "+userId;
        return jdbcTemplate.queryForObject(query, Integer.class);
    }
}
