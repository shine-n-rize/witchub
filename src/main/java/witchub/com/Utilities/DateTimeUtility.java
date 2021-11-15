package witchub.com.Utilities;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class DateTimeUtility {
    public String getCurrentDateTime(String format) {
        SimpleDateFormat localDateTimeFormat = new SimpleDateFormat(format);
        localDateTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String dateTime = localDateTimeFormat.format(new Date());
        return dateTime;
    }
}
