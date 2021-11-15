package witchub.com.services;

public interface SecurityService {
    public String findLoggedInUsername();
    public void autoLogin(String username, String password);
    public void notVerified();
    public void autoLogout();
}
