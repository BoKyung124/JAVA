// 이보경(2015682)
// 2023-01-03
// lab8-1: Jpanel Color Test (ColorTest.java)

package lab8;
import javax.swing.*;
import java.awt.*;

public class ColorTest extends JFrame {
	public ColorTest() {
		setTitle("JPanel Color Test");
		setSize(600, 300);
		setLayout(new GridLayout(2, 4, 10, 10));

		JLabel[] l = new JLabel[4];
		JPanel[] p = new JPanel[4];
		String s[] = { "Red", "Yellow", "Green", "Blue" };
		Color c[] = { Color.red, Color.yellow, Color.green, Color.blue };

		for (int i = 0; i < 4; i++) {
			l[i] = new JLabel(s[i]);
			l[i].setHorizontalAlignment(JLabel.CENTER);
			l[i].setFont(new Font("Arial", Font.BOLD, 20));
			add(l[i]);
		}

		for (int i = 0; i < 4; i++) {
			p[i] = new JPanel();
			p[i].setBackground(c[i]);
			p[i].setSize(40, 40);
			add(p[i]);
		}

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ColorTest();
	}

}
