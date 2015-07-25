package com.demo.foursquare.service;

import com.demo.foursquare.service.entity.Venue;

import java.util.List;

/**
 * Created by amin on 25/07/15.
 */
public interface FoursquareApi {

    /**
     * This method serves a list of Venues coming from Foursquare
     *
     * @param name
     * @return
     */
    List<Venue> findVenues(String name);
}
