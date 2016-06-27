package shifeiqi.test_6_7_07;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class MainThread {

	private File file = null;
	private ReadWriteLock lock = new ReentrantReadWriteLock(false);
	
	public ReadWriteLock getLock() {
		return lock;
	}

	public File getFile() {
		return file;
	}

	/**
	 * Ð´ÎÄ¼þ²Ù×÷
	 * 
	 * @throws IOException
	 */
	public void writeData() throws IOException {
		file = new File("d://test.txt");
		file.createNewFile();

		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		for (int i = 0; i < 10000; i++) {
			out.writeInt(i);
		}

		out.close();
	}

	@Test
	public void test() throws IOException, InterruptedException {

		writeData();


		ReaderThread r1 = new ReaderThread(this);
		r1.start();
		ReaderThread r2 = new ReaderThread(this);
		r2.start();

		WriterThread w2 = new WriterThread(this);
		w2.start();
		WriterThread w3 = new WriterThread(this);
		w3.start();
		WriterThread w4 = new WriterThread(this);
		w4.start();
		
		r1.join();
		r2.join();
		w2.join();
		w3.join();
		w4.join();

	}

}
