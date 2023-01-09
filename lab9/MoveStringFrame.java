// 이보경(2015682)
// 2023-01-04
// lab9-3: MoveStringFrame.java

package lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveStringFrame extends JFrame {
	JLabel lblS;

	public MoveStringFrame() {
		setTitle("Left 키로 문자열 회전");
		setSize(500, 300);

		lblS = new JLabel("Love Java");
		String s = lblS.getText();
		JPanel panel = new JPanel();
		add(panel);
		panel.add(lblS);

		panel.setFocusable(true);
		panel.requestFocus();

		panel.addKeyListener(new MyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					String s = lblS.getText();
					String subString = s.substring(1);
					s = subString + s.charAt(0);
					lblS.setText(s);
				}
			}
		});

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public class MyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

	public static void main(String[] args) {
		new MoveStringFrame();
	}

}