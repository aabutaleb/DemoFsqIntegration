package fsqint.service.impl;

import fsqint.service.entity.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by amin on 25/07/15.
 *
 * This class will make all the calls to 4sq API
 */

@Service
public class FoursquareApi {

    @Value("${4sq.client.id}")
    private String id;

    @Value("${4sq.client.secret}")
    private String secret;

    public FoursquareApi() {
        super();
    }

    public List<Venue> findVenues(final String name){
        return null;
    }
}
