package shifeiqi.test_5_02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.junit.Test;

/**
 * 
 * @author 
 *
 */
public class Client {

	public static int PORT = 8888;
	private Socket socket;
	
	/**
	 * 
	 * @param ip
	 * @throws Exception
	 */
	private void connection(String ip) throws Exception {
		socket = new Socket(ip, PORT);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		os.write("hello".getBytes());

		int len = 0;
		byte[] buff = new byte[1024];
		len = is.read(buff);
		String str = new String(buff, 0, len);
		System.out.println("服务器响应： " + str);
		
		is.close();
		os.close();
		socket.close();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception{
		connection("localhost");
	}
}
