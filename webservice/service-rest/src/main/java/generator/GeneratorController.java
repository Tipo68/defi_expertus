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

    @RequestMapping(value = "/get-text", method = RequestMethod.GET)
    public Text getText() throws IOException {
    	Text text = new Text(counter.incrementAndGet());
    	text.getText();
        return text;
    }
    
    @RequestMapping(value = "/generator", method = RequestMethod.POST)
    public Text generator(@RequestParam(value="size") int size) throws IOException {
    	Text text = new Text(counter.incrementAndGet());
    	text.createContent(size);
        return text;
    }
    
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public Text sort(@RequestParam(value="content", defaultValue="Expertus") String content, @RequestParam(value="order", defaultValue="up") String order) throws IOException {
    	Text text = new Text(0, content);
    	text.sortContent(order);
        return text;
    }
    
    @RequestMapping(value = "/sortAlph", method = RequestMethod.POST)
    public Text sortAlph(@RequestParam(value="content", defaultValue="Expertus") String content) throws IOException {
    	Text text = new Text(0, content);
    	text.sortContentAlph();
        return text;
    }
}
