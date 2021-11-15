package witchub.com.models;

import javax.validation.constraints.NotNull;

public class Request {

    @NotNull
    private int requestId;

    private String response;

    // foreign key(s)
    private int productId;
    private int userId;

    public Request(int requestId, String response, int productId, int buyerId) {
        this.requestId = requestId;
        this.response = response;
        this.productId = productId;
        this.userId = buyerId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", response='" + response + '\'' +
                ", productId=" + productId +
                ", buyerId=" + userId +
                '}';
    }
}
