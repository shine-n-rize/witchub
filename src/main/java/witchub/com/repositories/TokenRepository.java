package witchub.com.repositories;

import witchub.com.models.VerificationToken;

public interface TokenRepository {
    public VerificationToken getVerificationToken(String token);
    public void save(VerificationToken verificationToken);
}
