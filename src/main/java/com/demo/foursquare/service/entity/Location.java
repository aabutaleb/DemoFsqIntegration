package com.demo.foursquare.service.entity;


/**
 * Created by amin on 25/07/15.
 */
public class Location {
    private Double lat;
    private Double lng;

    public Location() {
        super();
    }

    public Location(Double lng, Double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
