package generator;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";

    @RequestMapping(value = "/generator", method = RequestMethod.GET)
    public Text greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Text(counter.incrementAndGet(), String.format(template, name));
    }
}
