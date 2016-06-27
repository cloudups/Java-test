package shifeiqi.test_5_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Test;

public class URLTest {
	public static String u = "http://www.sdust.edu.cn:80";

	private String protocol;
	private String host;
	private int port;
	private String path;

	/**
	 * 
	 * @throws IOException
	 */
	private void urlTest() throws IOException {
		URL url = new URL(u);
		protocol = url.getProtocol();
		host = url.getHost();
		port = url.getPort();
		path = url.getPath();

		System.out.println(
				"鍗忚锛� " + protocol + "\n" + "涓绘満鍚嶏細 " + host + "\n" + "绔彛鍙�: " + port + "\n" + "鏂囦欢璺緞锛� " + path);

		InputStream in = url.openStream();
		InputStreamReader read = new InputStreamReader(in);
		int l = 0;
		while ((l = read.read()) != -1) {
			System.out.print((char) l);
		}
	}

	/**
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		urlTest();
	}
}
