package witchub.com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import witchub.com.models.Seller;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SellerRepositoryImpl implements SellerRepository{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public SellerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Seller> sellerRowMapper = new RowMapper<Seller>() {
        @Override
        public Seller mapRow(ResultSet rs, int rowNum) throws SQLException {
            Seller seller = new Seller();
            seller.setSellerId(rs.getInt("seller_id"));
            seller.setWallet(rs.getInt("wallet"));
            seller.setDemandRate(rs.getFloat("demand_rate"));
            seller.setAccountNo(rs.getString("account_no"));
            return seller;
        }
    };

    @Override
    public void save(int sellerId){
        String query = "INSERT INTO Seller(seller_id) value(?)";
        jdbcTemplate.update(query, sellerId);
    }

    @Override
    public Seller findBySellerId(int sellerId) {
        String query = "SELECT * FROM Seller WHERE seller_id = '"+sellerId+"'";
        Seller seller = jdbcTemplate.queryForObject(query, sellerRowMapper);
        return seller;
    }
}
