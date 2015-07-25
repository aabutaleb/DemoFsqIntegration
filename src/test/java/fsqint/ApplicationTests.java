package fsqint;

import com.sun.javafx.binding.StringFormatter;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

	@Test
	public void contextLoads() {

	}

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
        params.put("query", "abcd");

        String url = Utils.getServiceURL("http://test", "id", "secret", params);

        Assert.assertNotNull(url);
        Assert.assertEquals("http://test?client_id=id&client_secret=secret&v="+now+"&query=abcd", url);
    }
}
