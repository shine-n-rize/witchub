package witchub.com.repositories;

import witchub.com.models.Seller;

public interface SellerRepository {
    public void save(int userId, String accountNo);
    public int getSellerIdByUserId(int userId);
}
