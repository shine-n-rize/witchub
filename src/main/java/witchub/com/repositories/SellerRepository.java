package witchub.com.repositories;

import witchub.com.models.Seller;

public interface SellerRepository {
    public void save(int sellerId);
    public Seller findBySellerId(int sellerId);
}
