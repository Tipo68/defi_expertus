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
	public void createContent() throws IOException {   // Methode pour générer le text random
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
}
