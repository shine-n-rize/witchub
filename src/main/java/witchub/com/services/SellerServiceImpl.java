package witchub.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import witchub.com.models.User;
import witchub.com.repositories.SellerRepository;
import witchub.com.repositories.UserRepository;

@Service
public class SellerServiceImpl implements SellerService{
    private SecurityService securityService;
    private UserRepository userRepository;
    private SellerRepository sellerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SellerServiceImpl(UserRepository userRepository, SellerRepository sellerRepository, SecurityService securityService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
        this.securityService = securityService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(String accountNo) {
        String encryptAccountNo = bCryptPasswordEncoder.encode(accountNo);
        String username = securityService.findLoggedInUsername();
        System.out.println(username);
        User user = userRepository.findByUsername(username);
        System.out.println(user.getRole());
        sellerRepository.save(user.getUserId(), encryptAccountNo);
    }

    public int getSellerIdByUserId(int userId){
        return sellerRepository.getSellerIdByUserId(userId);
    }
}
