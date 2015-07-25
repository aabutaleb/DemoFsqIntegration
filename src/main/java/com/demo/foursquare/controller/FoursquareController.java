package com.demo.foursquare.controller;

import com.demo.foursquare.service.FoursquareApi;
import com.demo.foursquare.service.entity.Venue;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by amin on 25/07/15.
 */
@RestController
@RequestMapping("/foursquare")
public class FoursquareController {

    private static final Logger LOG = Logger.getLogger(FoursquareController.class);

    @Autowired
    private FoursquareApi foursquareApi;

    /**
     * Method that serves Foursquare results to the view according to the query
     * @param query
     * @return
     */
    @RequestMapping(value = "/find/{query}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Venue> findPLaces(@PathVariable("query") final String query) {
        LOG.info(String.format("Receiving request to find %s", query));

        return foursquareApi.findVenues(query);
    }

}
