package witchub.com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import witchub.com.models.VerificationToken;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TokenRepositoryImpl implements TokenRepository{
    JdbcTemplate jdbcTemplate;
    UserRepository userRepository;

    @Autowired
    public TokenRepositoryImpl(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
    }

    @Override
    public VerificationToken getVerificationToken(String token) {
        String query = "SELECT * FROM Verification_Token WHERE token = '"+token+"'";
        return jdbcTemplate.queryForObject(query, new RowMapper<VerificationToken>() {
            @Override
            public VerificationToken mapRow(ResultSet resultSet, int i) throws SQLException {
                VerificationToken verificationToken = new VerificationToken();
                verificationToken.setId(resultSet.getInt("id"));
                verificationToken.setToken(resultSet.getString("token"));
                verificationToken.setUser(userRepository.findByUserId(resultSet.getInt("user_id")));
                verificationToken.setCreatedDate(resultSet.getDate("created_date"));
                verificationToken.setExpiryDate(resultSet.getDate("expiry_date"));
                return verificationToken;
            }
        });
    }

    @Override
    public void save(VerificationToken verificationToken) {
        String query = "INSERT INTO Verification_Token(token,user_id,created_date,expiry_date) VALUE (?,?,?,?)";
        jdbcTemplate.update(query,verificationToken.getToken(),verificationToken.getUser().getUserId(),verificationToken.getCreatedDate(),verificationToken.getExpiryDate());
    }
}
