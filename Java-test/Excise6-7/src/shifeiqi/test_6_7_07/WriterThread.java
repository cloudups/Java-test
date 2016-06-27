package shifeiqi.test_6_7_07;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;

public class WriterThread extends Thread {

	private MainThread main;
	private File file;
	private ReadWriteLock lock;

	public WriterThread(MainThread main) {
		this.main = main;
		this.file = main.getFile();
		this.lock = main.getLock();
	}

	@Override
	public void run() {
		lock.writeLock().lock();

		System.out.println(Thread.currentThread().getName() + "正在写文件");
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new FileOutputStream(file));
			out.writeInt((int) (Math.random() * 10000));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		lock.writeLock().unlock();
	}

}
