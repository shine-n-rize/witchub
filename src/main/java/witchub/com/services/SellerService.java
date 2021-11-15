package witchub.com.services;

import org.springframework.stereotype.Service;
import witchub.com.models.Seller;
import witchub.com.models.User;

public interface SellerService {
    public void save(String accountNo);
    public int getSellerIdByUserId(int userId);
}
