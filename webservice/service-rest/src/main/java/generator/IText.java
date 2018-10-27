package generator;

import java.io.IOException;

public interface IText {
	public void createContent(int size) throws IOException;
	public void sortContent(String order);
	public void sortContentAlph();
	public void getText() throws IOException;
}
