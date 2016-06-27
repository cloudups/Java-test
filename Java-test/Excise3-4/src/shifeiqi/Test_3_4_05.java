package shifeiqi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import org.junit.Test;

/**
 * 
 * @author feiqishi
 *
 */
public class Test_3_4_05 {

	@Test
	public void testOutputstream() throws IOException {
		File file = new File("d://Outputtest.txt");
		if (!file.exists())
			file.createNewFile();
		OutputStream out = new FileOutputStream(file);

		for (int i = 0; i < 1000000; i++) {
			out.write(i);
		}
		out.close();
	}

	@Test
	public void testReader() throws IOException {
		File file = new File("d://Writertest.txt");
		if (!file.exists())
			file.createNewFile();
		Writer out = new FileWriter(file);

		for (int i = 0; i < 1000000; i++) {
			out.write("" + i);
		}

		out.close();
	}
}
