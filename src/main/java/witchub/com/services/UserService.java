package witchub.com.services;

import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import witchub.com.models.User;
import witchub.com.models.VerificationToken;

public interface UserService {
    public void save(User user);
    public User findByUsername(String email);
    public boolean userExists(String email);
    public void createVerificationToken(User user, String token);
    public void enableRegisteredUser(User user);
    public VerificationToken getVerificationToken(String token);
    public User findByUserId(int id);
    public void assignRoleSeller(String email);

//    void deadUser(int userId);
}
