package com.demo.foursquare.service.impl;

import com.demo.foursquare.Utils;
import com.demo.foursquare.service.FoursquareApi;
import com.demo.foursquare.service.converter.Converter;
import com.demo.foursquare.service.entity.Venue;
import com.demo.foursquare.service.exception.FoursquareServiceException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
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
public class FoursquareApiImpl implements FoursquareApi {

    @Value("${4sq.client.id}")
    private String id;

    @Value("${4sq.client.secret}")
    private String secret;

    @Value("${4sq.server.url}")
    private String serviceURL;

    @Value("${4sq.server.version}")
    private String serviceVersion;

    public FoursquareApiImpl() {
        super();
    }

    @Override
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
