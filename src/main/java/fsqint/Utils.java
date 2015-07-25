package fsqint;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by amin on 25/07/15.
 */
public class Utils {
    private static final DateTimeFormatter FSQ_FORMATTER = DateTimeFormat.forPattern("YYYYMMDD");

    public static final String formatCurrentDate(){
        return FSQ_FORMATTER.print(DateTime.now());
    }

    public static String getServiceURL(String url, String id, String secret, String query) {
        return String.format("%s?client_id=%s&client_secret=%s&v=%s&%s",
                url, id, secret, Utils.formatCurrentDate(), query);
    }
}
