package witchub.com.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import witchub.com.Utilities.DateTimeUtility;
import witchub.com.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImpl implements UserRepository{
    JdbcTemplate jdbcTemplate;
    private DateTimeUtility dateTimeUtil;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, DateTimeUtility dateTimeUtil) {
        this.jdbcTemplate = jdbcTemplate;
        this.dateTimeUtil = dateTimeUtil;
    }


    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setPhoneNo(rs.getString("phone_no"));
            user.setStatus(rs.getBoolean("status"));
            user.setRole(rs.getString("role"));
            user.setPassword(rs.getString("password"));
            user.setDateCreated(rs.getDate("date_created"));
            user.setHouseNo(rs.getString("house_no"));
            user.setStreet(rs.getString("street"));
            user.setCity(rs.getString("city"));
            user.setHouseNo(rs.getString("house_no"));
            return user;
        }
    };

    @Override
    public User findByEmail(String email){
        try{
            String query = "SELECT * FROM User WHERE email='"+email+"'";
            return jdbcTemplate.queryForObject(query, userRowMapper);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public boolean userExists(String email) {
        String query = "SELECT COUNT(*) FROM User WHERE email = '"+email+"'";
        int cnt = jdbcTemplate.queryForObject(query, Integer.class);
        if(cnt>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void save(User user) {
        String query = "INSERT INTO User(username,first_name,last_name,email,phone_no,status,role,password,date_created,house_no,street,city) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,user.getUsername(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNo(),user.isStatus(),user.getRole(),user.getPassword(),dateTimeUtil.getCurrentDateTime("yyyy-MM-dd"),user.getHouseNo(),user.getStreet(),user.getCity());
    }

    @Override
    public void enableUser(User user) {
        String query = "update user set status = true where email='"+user.getEmail()+"'";
        jdbcTemplate.update(query);
    }

    @Override
    public User findByUserId(int id) {
        String query = "SELECT * FROM User WHERE user_id='"+id+"'";
        return jdbcTemplate.queryForObject(query, userRowMapper);
    }

    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM User WHERE username = ?";
            return (User) jdbcTemplate.queryForObject(sql, new Object[] { username },
                    new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void setRole(String role, String email) {
        User user = findByEmail(email);
        String query = "UPDATE User SET role = ? WHERE user_id = ?";
        jdbcTemplate.update(query, role, user.getUserId());
    }
}
