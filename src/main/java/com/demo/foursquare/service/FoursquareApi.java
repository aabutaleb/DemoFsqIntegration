package com.demo.foursquare.service;

import com.demo.foursquare.service.entity.Venue;

import java.util.List;

/**
 * Created by amin on 25/07/15.
 */
public interface FoursquareApi {
    List<Venue> findVenues(String name);
}
