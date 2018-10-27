package generator;

import java.io.IOException;
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
    public Text greeting(@RequestParam(value="name", defaultValue="Expertus") String name) throws IOException {
    	Text text = new Text(counter.incrementAndGet());
    	text.createContent();
        return text;
    }
}
