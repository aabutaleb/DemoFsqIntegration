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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
