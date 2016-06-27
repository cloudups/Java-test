package shifeiqi.test_6_7_02;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MainThread extends Thread{

	private int max = -1;
	private List<Integer> list = new ArrayList<>();
	@Test
	public void JoinTest() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
			list.add((int) (Math.random() * 10000));
			System.out.println(list.get(i));
		}

		ComputerThread thread1 = new ComputerThread(list.subList(0, 2000));
		thread1.start();
		thread1.join();
		ComputerThread thread2 = new ComputerThread(list.subList(2000, 4000));
		thread2.start();
		thread2.join();
		ComputerThread thread3 = new ComputerThread(list.subList(4000, 6000));
		thread3.start();
		thread3.join();
		ComputerThread thread4 = new ComputerThread(list.subList(6000, 8000));
		thread4.start();
		thread4.join();
		ComputerThread thread5 = new ComputerThread(list.subList(8000, 10000));
		thread5.start();
		thread5.join();
	
		if (max < thread1.getMax())
			max = thread1.getMax();
		if (max < thread2.getMax())
			max = thread2.getMax();
		if (max < thread4.getMax())
			max = thread3.getMax();
		if (max < thread4.getMax())
			max = thread4.getMax();
		if (max < thread5.getMax())
			max = thread5.getMax();
		
		System.out.println("the max: " + max);
	}
}
