package shifeiqi.test_6_7_06;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;

public class ReaderThread extends Thread {

	private MainThread main;
	private File file;
	private ReadWriteLock lock;

	public ReaderThread(MainThread main) {
		this.main = main;
		this.file = main.getFile();
		this.lock = main.getLock();
	}

	@Override
	public void run() {

		lock.readLock().lock();
		System.out.println(Thread.currentThread().getName() + "正在读文件");
		DataInputStream in = null;
		try {
			in = new DataInputStream(new FileInputStream(file));
			System.out.println("" + in.readInt());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		lock.readLock().unlock();
	}

}
