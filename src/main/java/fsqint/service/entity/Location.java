package fsqint.service.entity;

import java.util.List;

/**
 * Created by amin on 25/07/15.
 */
public class Location {
    private String address;
    private String crossStreet;
    private Double lat;
    private Double lng;
    private Double distance;
    private String cc;
    private String city;
    private String state;
    private String country;
    private List<String> formattedAddress;

    public Location() {
        super();
    }

    public Location(String address, Double lat, Double lng) {
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public Location(String address, String crossStreet, Double lat, Double lng, Double distance, String cc, String city, String state, String country, List<String> formattedAddress) {
        this.address = address;
        this.crossStreet = crossStreet;
        this.lat = lat;
        this.lng = lng;
        this.distance = distance;
        this.cc = cc;
        this.city = city;
        this.state = state;
        this.country = country;
        this.formattedAddress = formattedAddress;
    }
}
