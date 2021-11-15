package witchub.com.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import witchub.com.models.User;

public class OnSignupSuccessEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String appUrl;
    private User user;

    public OnSignupSuccessEvent(String appUrl, User user) {
        super(user);
        this.appUrl = appUrl;
        this.user = user;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
