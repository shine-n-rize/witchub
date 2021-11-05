package witchub.com.services;

import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;

public interface UserService {
    public void save(User user);
    public User findByUserName(String email);
    public boolean userExists(String email);
    public void createVerifiedToken(User user, String token);
    public void enableRegisteredUser(User user);
    public VerificationToken getVerificationToken(String token);
    public User findByUserId(int id);
    public void assignRole(String email);

//    void deadUser(int userId);
}
