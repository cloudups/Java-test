package shifeiqi;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test1_2_01 {

	public static void main(String[] args) {
		LabelFrame l = new LabelFrame();
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setVisible(true);
	}

}

class LabelFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 300;

	public LabelFrame() {
		setTitle("实验一.1");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		JPanel panel = new JPanel();

		JLabel l1 = new JLabel();
		l1.setBackground(Color.red);
		// 设置背景颜色为显示状态
		l1.setOpaque(true);
		// 设置label的size，注意setSize（）不可以调节大小
		Dimension d = getPreferredSize();
		d.height = DEFAULT_WIDTH;
		d.width = DEFAULT_HEIGHT / 3;
		l1.setPreferredSize(d);

		JLabel l2 = new JLabel();
		l2.setBackground(Color.yellow);
		// 设置背景颜色为显示状态
		l2.setOpaque(true);
		// 设置label的size，注意setSize（）不可以调节大小
		Dimension d2 = getPreferredSize();
		d2.height = DEFAULT_WIDTH;
		d2.width = DEFAULT_HEIGHT / 3;
		l2.setPreferredSize(d2);

		JLabel l3 = new JLabel();
		l3.setBackground(Color.blue);
		// 设置背景颜色为显示状态
		l3.setOpaque(true);
		// 设置label的size，注意setSize（）不可以调节大小
		Dimension d3 = getPreferredSize();
		d3.height = DEFAULT_WIDTH;
		d3.width = DEFAULT_HEIGHT / 3;
		l3.setPreferredSize(d3);

		panel.add(l1);
		panel.add(l2);
		panel.add(l3);

		this.setContentPane(panel);
	}
}