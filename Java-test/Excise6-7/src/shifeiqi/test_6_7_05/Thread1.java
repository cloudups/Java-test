package shifeiqi.test_6_7_05;

public class Thread1 extends Thread {

	Main main;

	public Thread1(Main main) {
		this.main = main;
	}

	@Override
	public void run() {
		while (true) {

			synchronized (main) {

				if (main.getFlag() != 1) {
					try {
						main.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				int w = main.getX1();
				int width = 100;
				if (main.getX1() == 0 && main.getX2() == 0) {
					width = 50;
				}
				for (int i = w; i < w + width; i++) {
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					main.setX1(i);

					if (main.getX1() >= main.PWIDTH - main.WIDTH) {

						main.sucess("¿∂∑ΩªÒ §£°£°");
						return;
					}
				}

				main.setFlag(2);
				main.notify();
			}

		}

	}

}
