package shifeiqi;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test1_2_02 {
	public static void main(String[] args) {
		Test1_2Frame frame = new Test1_2Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class Test1_2Frame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	private JTextField textField;
	private JLabel label;

	public Test1_2Frame() {

		textField = new JTextField();
		label = new JLabel();

		setTitle("สตั้าปฃบ2");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.add(textField);
		panel.add(label);

		JButton btn = new JButton("OK");

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText(textField.getText());
			}
		});
		panel.add(btn);
		setContentPane(panel);
	}
}
