package shifeiqi.test_6_7_01;

public class RunnableTest implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			int time = (int) (Math.random() * 10);
			try {
				Thread.sleep(time * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("thread name: " + Thread.currentThread().getName() + " sleep time: " + time
						+ " count: " + (i + 1));
			}
		}
	}

	public static void main(String[] args) {
		Thread test = new Thread(new RunnableTest());
		test.start();
	}
}
