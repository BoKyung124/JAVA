// 이보경(2015682)
// 2023-01-06
// lab11-2: 마름모 그리기 (DrawLineTest_2.java)

package lab11;

import javax.swing.*;
import java.awt.*;

public class DrawLineTest_2 extends JFrame {
	int w1, h1, w2, h2;

	public class MyPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(getGraphics());
			{
				Dimension d = getSize();

				// 왼쪽 위
				for (int i = 0; i < 10; i++) {
					w1 = d.width / 30 * i;
					h1 = d.height / 2;
					w2 = d.width / 2;
					h2 = d.height / 30 * i;
					g.drawLine(w1, h1, w2, h2);
				}

				// 오른쪽 위
				for (int i = 0; i < 10; i++) {
					w1 = d.width / 2;
					h1 = d.height / 30 * i;
					w2 = d.width - d.width / 30 * i;
					h2 = d.height / 2;
					g.drawLine(w1, h1, w2, h2);
				}

				// 왼쪽 아래
				for (int i = 0; i < 10; i++) {
					w1 = d.width / 30 * i;
					h1 = d.height / 2;
					w2 = d.width / 2;
					h2 = d.height - d.height / 30 * i;
					g.drawLine(w1, h1, w2, h2);
				}

				// 오른쪽 아래
				for (int i = 0; i < 10; i++) {
					w1 = d.width / 2;
					h1 = d.height - d.height / 30 * i;
					w2 = d.width - d.width / 30 * i;
					h2 = d.height / 2;
					g.drawLine(w1, h1, w2, h2);
				}

			}
		}
	}

	public DrawLineTest_2() {
		setTitle("그래픽 다각형 연습");
		setSize(300, 300);
		add(new MyPanel());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DrawLineTest_2();
	}

}
