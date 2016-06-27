package shifeiqi.test_5_03;

import java.net.DatagramSocket;
import java.net.SocketException;

import org.junit.Test;

/**
 * 
 * @author feiqishi
 *
 */
public class TestPort {

	@Test
	public void test() throws SocketException {
		boolean is = testPort(9999);
		if (is)
			System.out.println("端口可以使用");
		else
			System.out.println("端口已经被占用");
	}

	/**
	 * 测试端口占用方法
	 * 
	 * @param port
	 *            端口号
	 * @return
	 */
	private boolean testPort(int port) {

		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(port);
			return true;
		} catch (SocketException e) {
			return false;
		}finally{
			ds.close();
		}
	}
}