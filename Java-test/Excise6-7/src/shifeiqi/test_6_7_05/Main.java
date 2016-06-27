package shifeiqi.test_6_7_05;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {

	static public int PWIDTH = 1000;
	static public int WIDTH = 30;
	static private int HEIGHT = 30;
	static private int PHEIGHT = 400;
	static private int Y = 200;

	private int flag = 1;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	private int x1 = 0;
	private int x2 = 0;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
		l1.setBounds(x1, Y, WIDTH, HEIGHT);
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
		l2.setBounds(x2, Y, WIDTH, HEIGHT);
	}

	public void sucess(String str) {
		l3.setText(str);
		l3.setBounds(PWIDTH / 2 - 50, PHEIGHT / 2 - 50, 200, 100);
		l3.setVisible(true);
	}

	public Main() {
		setTitle("Äã×·ÎÒ¸Ï");
		setSize(PWIDTH, PHEIGHT);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		l1 = new JLabel();
		l1.setBackground(Color.blue);
		// ÉèÖÃ±³¾°ÑÕÉ«ÎªÏÔÊ¾×´Ì¬
		l1.setOpaque(true);
		l1.setBounds(x1, Y, WIDTH, HEIGHT);

		l2 = new JLabel();
		l2.setBackground(Color.RED);
		// ÉèÖÃ±³¾°ÑÕÉ«ÎªÏÔÊ¾×´Ì¬
		l2.setOpaque(true);
		l2.setBounds(x2, Y, WIDTH, HEIGHT);

		l3 = new JLabel();
		l3.setVisible(false);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);

		this.setContentPane(panel);
	}

	public static void main(String[] args) throws InterruptedException {
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);

		Thread2 thread2 = new Thread2(main);
		thread2.start();

		Thread1 thread = new Thread1(main);
		thread.start();
	}

}
