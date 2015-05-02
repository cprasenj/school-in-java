package hello;

import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public GreetingController() {
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String index(ModelMap model) {
        DB db  = new DB();
        db.getColl();
        return new StringBuilder().append("<h1>HELLO WORLD").append(db.getColl().get("name")).append("</h1>").toString();
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/gth")
    public Greeting greeting1(@RequestParam(value="name", defaultValue="gth") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}