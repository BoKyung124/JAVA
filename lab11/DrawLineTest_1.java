// 이보경(2015682)
// 2023-01-06
// lab11-2: 격자그리기 (DrawLineTest_1.java)

package lab11;

import javax.swing.*;
import java.awt.*;

public class DrawLineTest_1 extends JFrame {
	class MyPanel extends JPanel {
		int w, h;

		protected void paintComponent(Graphics g) {
			super.paintComponent(getGraphics());
			Dimension d = getSize();
			g.setColor(Color.black);

			// 가로선
			for (int i = 0; i < 10; i++) {
				w = d.width;
				h = d.height / 10 * i;
				g.drawLine(0, h, w, h);
			}

			// 세로선
			for (int i = 0; i < 10; i++) {
				w = d.width / 10 * i;
				h = d.height;
				g.drawLine(w, 0, w, h);
			}
		}
	}

	public DrawLineTest_1() {
		setTitle("격자 그리기");
		setSize(400, 300);
		add(new MyPanel());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DrawLineTest_1();
	}

}
