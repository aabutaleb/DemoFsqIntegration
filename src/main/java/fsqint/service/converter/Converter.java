package fsqint.service.converter;

import fsqint.service.entity.Location;
import fsqint.service.entity.Venue;
import fsqint.service.exception.ConversionException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by amin on 25/07/15.
 *
 * This approach is only justified by the simplicity of the example.
 * In more complex problems, it should use Spring's ConversionService with dynamic declararion of converters.
 *
 * @see org.springframework.core.convert.ConversionService
 */
public class Converter {
    public static List<Venue> convert (String json) {
        List<Venue> venueList = new ArrayList<>();

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);
            JsonNode venues = root.findPath("venues");

            venues.getElements().forEachRemaining(venue -> venueList.add(convert(venue)));

        }catch (IOException e){
            throw new ConversionException(e);
        }

        return venueList;
    }

    private static Venue convert(JsonNode json){
        Venue venue = new Venue();
        Location location = new Location();
        venue.setLocation(location);

        venue.setId(json.get("id").asText());
        venue.setName(json.get("name").asText());

        Optional.ofNullable(json.get("url")).ifPresent(url -> venue.setUrl(url.asText()));

        JsonNode jsonLocation = json.findPath("location");
        location.setLat(jsonLocation.get("lat").asDouble());
        location.setLng(jsonLocation.get("lng").asDouble());

        return venue;
    }
}
