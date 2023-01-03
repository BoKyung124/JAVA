// 이보경(2015682)
// 2023-01-03
// lab8-3: 난수 발생 (MyFrame.java)

package lab8;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("My Frame");
		setSize(500, 400);
		getContentPane().setLayout(null);
		int a, b;

		Random random = new Random();

		for (int i = 0; i < 30; i++) {
			a = random.nextInt(400);
			b = random.nextInt(300);
			JLabel label = new JLabel(random.nextInt(30) + "");
			label.setForeground(Color.magenta);
			label.setBounds(a, b, 20, 20);
			label.setOpaque(false);
			add(label);
		}

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
