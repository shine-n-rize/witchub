package witchub.com.models;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Order {

    @NotNull
    private int orderId;

    private Date datePlaced;
    private String status;

    // foreign key(s)
    private int paymentId;
    private int buyerId;
    private int cartId;

    public Order(int orderId, Date datePlaced, String status, int paymentId, int buyerId, int cartId) {
        this.orderId = orderId;
        this.datePlaced = datePlaced;
        this.status = status;
        this.paymentId = paymentId;
        this.buyerId = buyerId;
        this.cartId = cartId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", datePlaced=" + datePlaced +
                ", status='" + status + '\'' +
                ", paymentId=" + paymentId +
                ", buyerId=" + buyerId +
                ", cartId=" + cartId +
                '}';
    }
}
