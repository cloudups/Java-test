package shifeiqi.test_5_04;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

/**
 * 
 * @author feiqishi
 *
 */
public class TestUDPClient1 {

	@Test
	public void testSend() throws Exception {
		sendFile("d:/test.chm");
	}

	private void sendFile(String path) throws Exception {

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		byte[] buff = new byte[512];
		DatagramSocket ds = new DatagramSocket();

		InetAddress address = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp2 = new DatagramPacket(file.getName().getBytes(), file.getName().getBytes().length, address,
				9999);
		ds.send(dp2);

		while (fis.read(buff) != -1) {
			System.out.println(buff.toString());
			DatagramPacket dp = new DatagramPacket(buff, buff.length, address, 9999);
			ds.send(dp);
		}
		ds.close();
	}

}