package fsqint.controller;

import fsqint.service.impl.FoursquareApi;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amin on 25/07/15.
 */
@RestController
@RequestMapping("/foursquare")
public class FsqController {

    private static final Logger LOG = Logger.getLogger(FsqController.class);

    @Autowired
    private FoursquareApi foursquareApi;

    @RequestMapping(value = "/find/{query}", method = RequestMethod.GET)
    public void findPLaces(@PathVariable("query") final String query) {
        LOG.info(String.format("Receiving request to find %s", query));

        foursquareApi.findVenues(query);
    }

}
