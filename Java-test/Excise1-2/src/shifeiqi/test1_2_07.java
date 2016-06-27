package shifeiqi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class test1_2_07 {
	public static void main(String[] args) {

		DrawCircle d = new DrawCircle();
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setVisible(true);
	}

}

class DrawCircle extends JFrame {
	ArrayList<Point> points = new ArrayList<>();

	public static final int DEFAULT_WIDTH = 1000;
	public static final int DEFAULT_HEIGHT = 1000;
	private Point start, end;
	private Point mid = new Point();

	public DrawCircle() {
		setTitle("DrawCircle");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		this.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent arg0) {
				points.add(new Point(arg0.getX(), arg0.getY()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				DrawCircle d = (DrawCircle) e.getSource();
				points.add(new Point(e.getX(), e.getY()));
				d.repaint();
			}

		});

		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < points.size(); i += 2) {

			start = points.get(i);
			end = points.get(i + 1);
			mid.x = (start.x + end.x) / 2;
			mid.y = (start.y + end.y) / 2;

			int r = (int) Math.sqrt((start.x - end.x) * (start.x - end.x) + (start.y - end.y) * (start.y - end.y)) / 2;

			g.setColor(Color.black);
			g.drawOval(start.x, start.y, 2, 2);
			g.drawOval(end.x, end.y, 2, 2);
			g.setColor(Color.BLUE);
			g.drawOval(mid.x - r, mid.y - r, r * 2, r * 2);

			System.out.println("sx: " + start.x + ", ex: " + end.x + ", mx: " + (start.x + end.x) / 2);
		}
	}
}
