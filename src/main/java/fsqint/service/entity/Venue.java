package fsqint.service.entity;

/**
 * Created by amin on 25/07/15.
 */
public class Venue {
    private String id;
    private String name;
    private String url;
    private Location location;

    public Venue() {
        super();
    }

    public Venue(String id, String name, String url, Location location) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.location = location;
    }
}
