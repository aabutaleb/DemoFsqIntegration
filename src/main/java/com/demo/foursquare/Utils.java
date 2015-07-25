package com.demo.foursquare;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.net.URLEncoder;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by amin on 25/07/15.
 */
public class Utils {
    private static final DateTimeFormatter FSQ_FORMATTER = DateTimeFormat.forPattern("yyyyMMdd");

    /**
     * This method returns the date in the specific format for Foursquare queries
     * @return
     */
    public static final String formatCurrentDate(){
        return FSQ_FORMATTER.print(DateTime.now());
    }

    /**
     * This method composes the request URL to make a call to Foursquare API.
     * Easily reusable, you just need to pass the parameters, no need to duplicate the code to compose more calls.
     * @param url
     * @param id
     * @param secret
     * @param queryParams
     * @return
     */
    public static String getServiceURL(String url, String id, String secret, Map<String,String> queryParams) {
        String params = queryParams.entrySet().stream().
        map(param -> String.format("%s=%s", param.getKey(), encode(param.getValue())))
        .collect(Collectors.joining());

        return String.format("%s?client_id=%s&client_secret=%s&v=%s&%s",
                url, id, secret, Utils.formatCurrentDate(), params);
    }

    /**
     * Necessary to send special characters via HTTP request, this method will fix this.
     * @param value
     * @return
     */
    private static String encode(String value) {
        try {
           return URLEncoder.encode(value, "UTF-8");
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
