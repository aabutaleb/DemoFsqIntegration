package fsqint.service.impl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import fsqint.Utils;
import fsqint.service.converter.Converter;
import fsqint.service.entity.Venue;
import fsqint.service.exception.FoursquareServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public FoursquareApi() {
        super();
    }

    public List<Venue> findVenues(final String name){
        Client client = Client.create();
        Map<String, String> params = new HashMap<>();
        params.put("near", name);

        final WebResource webResource2 = client.resource(Utils.getServiceURL(getBaseURL() + "/venues/search", id, secret, params));

        final ClientResponse rs = webResource2.accept("application/json").get(ClientResponse.class);

        if (rs.getStatus() != 200) {
            throw new FoursquareServiceException("Error: Code: " + rs.getStatus());
        }

        return Converter.convert(rs.getEntity(String.class));
    }

    private String getBaseURL(){
        return String.format("%s/%s", serviceURL, serviceVersion);
    }
}
