package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Request {

    @NotNull
    private int requestId;

    private String response;

    // foreign key(s)
    private int productId;
    private int buyerId;

    public Request(int requestId, String response, int productId, int buyerId) {
        this.requestId = requestId;
        this.response = response;
        this.productId = productId;
        this.buyerId = buyerId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", response='" + response + '\'' +
                ", productId=" + productId +
                ", buyerId=" + buyerId +
                '}';
    }
}
