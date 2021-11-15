package witchub.com.repositories;

import witchub.com.models.User;

public interface UserRepository {
    public User findByEmail(String email);
    public boolean userExists(String email);
    public void save(User user);
    public void enableUser(User user);
    public User findByUserId(int id);
    public User findByUsername(String username);
    public void setRole(String role,String email);
}
