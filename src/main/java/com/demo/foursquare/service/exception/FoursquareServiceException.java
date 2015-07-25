package com.demo.foursquare.service.exception;

/**
 * Created by amin on 25/07/15.
 */
public class FoursquareServiceException extends RuntimeException{
    public FoursquareServiceException() {
        super();
    }

    public FoursquareServiceException(String message) {
        super(message);
    }

    public FoursquareServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoursquareServiceException(Throwable cause) {
        super(cause);
    }

    protected FoursquareServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
