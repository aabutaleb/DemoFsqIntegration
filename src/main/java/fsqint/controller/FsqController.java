package fsqint.controller;

import org.apache.log4j.Logger;
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

    @RequestMapping(value = "/find/{query}", method = RequestMethod.GET)
    public void findPLaces(@PathVariable("query") final String query) {
        LOG.info(String.format("Receiving request to find %s", query));
    }

}
