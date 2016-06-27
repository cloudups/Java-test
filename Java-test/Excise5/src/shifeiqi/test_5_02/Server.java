package shifeiqi.test_5_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * 服务器端
 * 
 * @author 石飞琪
 *
 */
public class Server {

	//服务器端口号
	public static int PORT = 8888;
	
	private ServerSocket server;

	/**
	 * 开启服务方法
	 *
	 * @throws IOException
	 */
	private void server() throws IOException {
		server = new ServerSocket(PORT);

		while (true) {
			Socket socket = server.accept();
			
			//开启服务线程
			ServerThread thread = new ServerThread(socket);
			thread.start();
		}

	}

	/**
	 * 测试方法
	 * 
	 * @throws IOException
	 */
	@Test
	public void text() throws IOException {
		server();
	}
}
