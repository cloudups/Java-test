package shifeiqi.test_5_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 服务器子线程
 * 
 * @author 石飞琪
 *
 */
public class ServerThread extends Thread {

	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		try {
			//获取输入输出流
			is = socket.getInputStream();
			os = socket.getOutputStream();

			//读取客户端
			int len = 0;
			byte[] buff = new byte[1024];
			len = is.read(buff);
			String str = new String(buff, 0, len);
			
			//响应客户端
			if (str.equals("hello")) {
				System.out.println("客户端响应： " + str);
				os.write("hello".getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
