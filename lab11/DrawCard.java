// 이보경(2015682)
// 2023-01-06
// lab11-1: DrawCard.java

package lab11;

import javax.swing.*;
import java.awt.*;

public class DrawCard extends JFrame {
	Image img;

	class MyPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawLine(20, 10, 380, 10);

			g.setColor(Color.lightGray);
			g.fillRoundRect(40, 30, 100, 100, 20, 20);

			g.drawImage(img, 53, 40, 80, 80, null);

			g.setColor(Color.black);
			g.setFont(new Font("Gothic", Font.BOLD, 20));
			g.drawString("이보경", 230, 60);
			g.drawString("3학년 학생", 212, 90);
			g.drawString("숙명여자대학교", 198, 120);

			g.drawLine(20, 150, 380, 150);
		}
	}

	public DrawCard() {
		setTitle("나의 명함");

		ImageIcon icon = new ImageIcon("original.png");
		img = icon.getImage();

		MyPanel p = new MyPanel();
		add(p);

		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DrawCard();
	}

}
