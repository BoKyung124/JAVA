// 이보경(2015682)
// 2023-01-06
// lab11-3: 신호등 예제 (TrafficTest.java)

package lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficTest extends JFrame {
	JButton button = new JButton("traffic light turn on");
	static int count = 0;
	int r = 100;
	Color color = Color.red;

	public class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Dimension d = getSize();
			g.setColor(color);
			g.fillOval(d.width / 2 - 50, 60 + (100 * (count % 3)), 100, 100);
			g.setColor(Color.black);
			g.drawOval(d.width / 2 - 50, 60, 100, 100);
			g.drawOval(d.width / 2 - 50, 160, 100, 100);
			g.drawOval(d.width / 2 - 50, 260, 100, 100);
			repaint();
		}
	}

	public TrafficTest() {
		setSize(300, 500);
		add(new MyPanel());

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(count);
				if (count % 3 == 2)
					color = Color.red;
				else if (count % 3 == 0)
					color = Color.green;
				else if (count % 3 == 1)
					color = Color.yellow;
				count += 1;
			}
		});

		add(button, "South");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TrafficTest();
	}

}
