package generator;

import java.io.IOException;

public interface IText {
	public void createContent() throws IOException;
	public void sortContent(String order);
}
