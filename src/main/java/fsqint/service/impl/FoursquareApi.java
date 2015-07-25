package fsqint.service.impl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import fsqint.Utils;
import fsqint.service.entity.Venue;
import fsqint.service.exception.FoursquareServiceException;
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

    @Value("${4sq.server.url}")
    private String serviceURL;

    @Value("${4sq.server.version}")
    private String serviceVersion;

    private final String baseURL;

    public FoursquareApi() {
        super();

        baseURL = String.format("%s/%s", serviceURL, serviceVersion);
    }

    public List<Venue> findVenues(final String name){
        Client client = Client.create();
        final WebResource webResource2 = client.resource(String.format("%s/venues/search?client_id=%s&client_secret=%s&v=%s&near=",
                baseURL, id, secret, Utils.formatCurrentDate()));

        final ClientResponse rs = webResource2.accept("application/json").get(ClientResponse.class);

        if (rs.getStatus() != 200) {
            throw new FoursquareServiceException("Error: Code: " + rs.getStatus());
        }

        return null;
    }
}
