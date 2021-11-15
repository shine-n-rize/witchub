package witchub.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import witchub.com.models.User;
import witchub.com.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        List<GrantedAuthority> grantList = new ArrayList<>();
        String[] roles = user.getRole().split(" ");
        for(int i=0;i<roles.length;i++){
            GrantedAuthority authority = new SimpleGrantedAuthority(roles[i]);
            grantList.add(authority);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),user.getPassword(),grantList
        );
    }
}
