package shifeiqi.test_5_04;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.junit.Test;

/**
 * 
 * @author feiqishi
 *
 */
public class TestUDPServer {

	@Test
	public void testReceive() throws Exception {
		receiveFile();
	}

	private void receiveFile() throws Exception {

		DatagramSocket ds = new DatagramSocket(9999);

		byte[] buff = new byte[512];
		DatagramPacket dp = new DatagramPacket(buff, buff.length);
		ds.receive(dp);

		String fileName = new String(buff);
		// System.out.println("fileName:/" + fileName.trim() + "/");
		File file = new File("d://1" + fileName.trim());
		// System.out.println(file.getName());

		file.createNewFile();

		FileOutputStream fos = new FileOutputStream(file);

		// System.out.println("create after");

		while (true) {
			DatagramPacket dp1 = new DatagramPacket(buff, buff.length);
			ds.receive(dp1);
			fos.write(buff);
			fos.flush();
		}
	}
}
