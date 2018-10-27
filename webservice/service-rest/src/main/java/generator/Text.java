package generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.core.io.ClassPathResource;

public class Text implements IText{
    private final long id;
    private String content = "";
    
	public Text(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void createContent() throws IOException {
    	File resource = new ClassPathResource("words_list.txt").getFile();
    	ArrayList<String> result = new ArrayList<>();
    	 
    	try (FileReader f = new FileReader(resource)) {
    	    StringBuffer sb = new StringBuffer();
    	    while (f.ready()) {
    	        char c = (char) f.read();
    	        if (c == ' ') {
    	            result.add(sb.toString().replaceAll("[!.,()-:?;]", "").toLowerCase());
    	            sb = new StringBuffer();
    	        } else {
    	            sb.append(c);
    	        }
    	    }
    	    if (sb.length() > 0) {
    	        result.add(sb.toString());
    	    }
    	}
    	
    	for(int i = 0; i < 200; i++) {
    		int index = (int) (Math.random() * ( 999 - 0 ));
    		this.content += " "  + result.get(index);
    	}
	}
}
