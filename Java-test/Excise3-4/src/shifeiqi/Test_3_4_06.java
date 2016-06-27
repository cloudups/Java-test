package shifeiqi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * 
 * @author feiqishi
 *
 */
public class Test_3_4_06 {

	@Test
	public void testInputStream() throws IOException {

		File file = new File("d://test.avi");
		InputStream in = new FileInputStream(file);
		while (in.read() != -1) {
			System.out.println("--");
		}
	}

	@Test
	public void testInputStreamWithBuffer() throws IOException {

		byte[] buf = new byte[1024];
		File file = new File("d://test.avi");
		InputStream in = new FileInputStream(file);
		while (in.read(buf) != -1) {
			System.out.println("--");
		}
	}

	@Test
	public void testBufferInputStream() throws IOException {

		File file = new File("d://test.avi");
		InputStream in = new FileInputStream(file);
		BufferedInputStream bin = new BufferedInputStream(in);
		while (bin.read() != -1) {
			System.out.println("--");
		}
	}

	@Test
	public void testBufferInputStreamWithBuf() throws IOException {

		byte[] buf = new byte[1024];
		File file = new File("d://test.avi");
		InputStream in = new FileInputStream(file);
		BufferedInputStream bin = new BufferedInputStream(in);
		while (bin.read(buf) != -1) {
			System.out.println("--");
		}
	}

}
