package com.demo.foursquare;

import com.demo.foursquare.service.converter.Converter;
import com.demo.foursquare.service.entity.Location;
import com.demo.foursquare.service.entity.Venue;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Test
	public void UtilDateFormatterTest(){
        DateTime now = DateTime.now();

        String current = Utils.formatCurrentDate();
        Assert.assertNotNull(current);
        Assert.assertEquals(String.format("%d%02d%02d", now.getYear(), now.getMonthOfYear(), now.getDayOfMonth()), current);
    }


    @Test
    public void UtilServiceUrlTest(){
        String now = Utils.formatCurrentDate();
        Map<String, String> params = new HashMap<>();
        params.put("query", "abcd efg");

        String url = Utils.getServiceURL("http://test", "id", "secret", params);

        Assert.assertNotNull(url);
        Assert.assertEquals("http://test?client_id=id&client_secret=secret&v="+now+"&query=abcd+efg", url);
    }

    @Test
    public void NullResultTest(){
        List<Venue> venues = Converter.convert(null);

        Assert.assertNotNull(venues);
        Assert.assertEquals(0, venues.size());
    }

    @Test
    public void EmptyResultTest(){
        List<Venue> venues = Converter.convert("{}");

        Assert.assertNotNull(venues);
        Assert.assertEquals(0, venues.size());
    }

    @Test
    public void NoLocationConverterTest(){
        List<Venue> venues = Converter.convert("{\n" +
                "    \"meta\": {\n" +
                "        \"code\": \"200\"\n" +
                "    },\n" +
                "    \"notifications\": [\n" +
                "        {\n" +
                "            \"type\": \"notificationTray\",\n" +
                "            \"item\": {\n" +
                "                \"unreadCount\": \"48\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"response\": {\n" +
                "        \"venues\": [\n" +
                "            {\n" +
                "                \"id\": \"51eabef6498e10cf3aea7942\",\n" +
                "                \"name\": \"Brooklyn Bridge Park - Pier 2\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}");
        Assert.assertNotNull(venues);
        Assert.assertEquals(1, venues.size());

        Assert.assertNull(venues.get(0).getLocation());
    }
    @Test
    public void NormalConversionTest(){
        List<Venue> venues = Converter.convert("{\n" +
                "    \"meta\": {\n" +
                "        \"code\": \"200\"\n" +
                "    },\n" +
                "    \"notifications\": [\n" +
                "        {\n" +
                "            \"type\": \"notificationTray\",\n" +
                "            \"item\": {\n" +
                "                \"unreadCount\": \"48\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"response\": {\n" +
                "        \"venues\": [\n" +
                "            {\n" +
                "                \"id\": \"51eabef6498e10cf3aea7942\",\n" +
                "                \"name\": \"Brooklyn Bridge Park - Pier 2\",\n" +
                "                \"location\": {\n" +
                "                    \"address\": \"Furman St\",\n" +
                "                    \"crossStreet\": \"Brooklyn Bridge Park Greenway\",\n" +
                "                    \"lat\": \"40.699511638395514\",\n" +
                "                    \"lng\": \"-73.99813359642076\",\n" +
                "                    \"distance\": \"166\",\n" +
                "                    \"cc\": \"US\",\n" +
                "                    \"city\": \"Brooklyn\",\n" +
                "                    \"state\": \"NY\",\n" +
                "                    \"country\": \"United States\",\n" +
                "                    \"formattedAddress\": [\n" +
                "                        \"Furman St (Brooklyn Bridge Park Greenway)\",\n" +
                "                        \"Brooklyn, NY\",\n" +
                "                        \"United States\"\n" +
                "                    ]\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}");
        Assert.assertNotNull(venues);
        Assert.assertEquals(1, venues.size());

        Venue venue = venues.get(0);
        Assert.assertEquals("Brooklyn Bridge Park - Pier 2", venue.getName());
        Assert.assertEquals("51eabef6498e10cf3aea7942", venue.getId());

        Location loc = venue.getLocation();
        Assert.assertNotNull(loc);
        Assert.assertEquals(new Double(40.699511638395514), loc.getLat());
        Assert.assertEquals(new Double(-73.99813359642076), loc.getLng());
    }

}
