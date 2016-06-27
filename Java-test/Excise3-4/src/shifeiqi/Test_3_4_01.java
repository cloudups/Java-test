package shifeiqi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
/**
 * 
 * @author feiqishi
 *
 */
public class Test_3_4_01 {

	public final String EXIT = "exit";
	private final String FILE_NAME = "d:/test.txt";

	/**
	 * test method
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		File file = new File(FILE_NAME);
		FileWriter fw = new FileWriter(file);
		String str = null;

		while (!(str = read()).equals(EXIT)) {
			fw.write(str);
		}

		fw.close();
	}

	/**
	 * read the string from the term
	 * 
	 * @return
	 * @throws IOException
	 */
	private String read() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();

		if (str.equals(EXIT)) {
			isr.close();
			br.close();
		}

		return str;
	}
}
