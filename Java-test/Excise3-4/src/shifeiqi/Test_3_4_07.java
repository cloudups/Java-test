package shifeiqi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 
 * @author feiqishi
 *
 */
public class Test_3_4_07 {
	private final String ENCODING = "GBK";
	private final String FILE_NAME = "D:/test.txt";

	/**
	 * test method
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		out(readTerm());
		readFile();
	}

	/**
	 * read the string from the terminal
	 * 
	 * @return
	 * @throws IOException
	 */
	private String readTerm() throws IOException {
		InputStreamReader in = new InputStreamReader(System.in, ENCODING);
		BufferedReader br = new BufferedReader(in);
		String str = br.readLine();
		return str;
	}

	/**
	 * out the string to the file
	 * 
	 * @param str
	 * @throws IOException
	 */
	private void out(String str) throws IOException {
		File file = new File(FILE_NAME);

		OutputStream ou = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(ou, ENCODING);
		osw.write(str);
		osw.flush();
	}

	/**
	 * read string from the file
	 * 
	 * @throws IOException
	 */
	private void readFile() throws IOException {
		File file = new File(FILE_NAME);
		InputStream in = new FileInputStream(file);
		InputStreamReader inr = new InputStreamReader(in, ENCODING);
		int h;
		while ((h = inr.read()) != -1) {
			System.out.println((char) h);
		}

		in.close();
		inr.close();
	}
}
