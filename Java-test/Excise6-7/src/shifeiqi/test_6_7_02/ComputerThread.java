package shifeiqi.test_6_7_02;

import java.util.List;

public class ComputerThread extends Thread {

	private List<Integer> list;
	private int max = -1;;

	public ComputerThread(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {

		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i))
				max = list.get(i);
//			System.out.println("ct :  " + list.get(i));
		}
	}


	public int getMax() {
//		System.out.println("max: " + max);
		return max;
	}
}
