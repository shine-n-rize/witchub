package witchub.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityServiceImpl(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void notVerified() {
        SecurityContextHolder.clearContext();
    }

    @Override
    public String findLoggedInUsername() {
        try{
            Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            System.out.println(userDetails.getClass());
            if (userDetails instanceof UserDetails) {
                return ((UserDetails) userDetails).getUsername();
            }
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return null;
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, password, userDetails.getAuthorities()
        );
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    public void autoLogout() {
        SecurityContextHolder.clearContext();
    }
}
