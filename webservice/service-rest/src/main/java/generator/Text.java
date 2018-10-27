package generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.core.io.ClassPathResource;

public class Text implements IText{
    private final long id;
    private String content = "";
    
	public Text(long id) {
		super();
		this.id = id;
	}
	
	public Text(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	@Override
	public void createContent(int size) throws IOException {   // Methode pour générer le text random
    	File resource = new ClassPathResource("words_list.txt").getFile();
    	ArrayList<String> result = new ArrayList<>();
    	 
    	try (FileReader f = new FileReader(resource)) {
    	    StringBuffer sb = new StringBuffer();
    	    while (f.ready()) {
    	        char c = (char) f.read();
    	        if (c == ' ') {
    	            result.add(sb.toString().replaceAll("[!.,():?;«»1234567890]", "").toLowerCase());
    	            sb = new StringBuffer();
    	        } else {
    	            sb.append(c);
    	        }
    	    }
    	    if (sb.length() > 0) {
    	        result.add(sb.toString());
    	    }
    	}
    	
    	for(int i = 0; i < size; i++) {
    		int index = (int) (Math.random() * ( 1544 - 0 ));
    		if(!result.get(index).equals("-")) {
    			this.content += " "  + result.get(index);
    		}
    	}
	}

	@Override
	public void sortContent(String order) {     // Méthode pour trier le text
		String[] contentAr = this.content.split(" ");

		if(order.equals("up")) {
			for(int i = contentAr.length - 1; i >= 1; i--) {
				for(int j = 2; j <= i; j++) {
					if(contentAr[j - 1].length() > contentAr[j].length()) {
						String temp = contentAr[j - 1];
						contentAr[j - 1] = contentAr[j];
						contentAr[j] = temp;
					}
				}
			}
		}else {
			for(int i = contentAr.length - 1; i >= 1; i--) {
				for(int j = 2; j <= i; j++) {
					if(contentAr[j ].length() > contentAr[j - 1].length()) {
						String temp = contentAr[j - 1];
						contentAr[j - 1] = contentAr[j];
						contentAr[j] = temp;
					}
				}
			}
		}
		
		this.content = "";
    	for(int i = 0; i < contentAr.length; i++) {
        	this.content += " "  + contentAr[i];
    	}
	}

	@Override
	public void sortContentAlph() {
		List<String> text = new ArrayList<String>(Arrays.asList(this.content.split(" ")));
		Collections.sort(text, Collator.getInstance(Locale.FRENCH));
		this.content = "";
    	for(int i = 0; i < text.size(); i++) {
    		this.content += " "  + text.get(i);
    	}
	}

	@Override
	public void getText() throws IOException {
    	File resource = new ClassPathResource("words_list.txt").getFile();
    	this.content = new String(Files.readAllBytes(resource.toPath()));
	}
}
