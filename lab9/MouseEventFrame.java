// 이보경(2015682)
// 2023-01-04
// lab9-2: MouseEventFrame.java

package lab9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventFrame extends JFrame {
	JLabel lbl;

	public MouseEventFrame() {
		setTitle("마우스 올리기 내리기");
		setSize(400, 300);
		setLayout(new BorderLayout());

		lbl = new JLabel("Love Java");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		add(lbl, "North");

		lbl.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lbl.setText("사랑해");
			}

			public void mouseExited(MouseEvent e) {
				lbl.setText("Love Java");
			}
		});

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public abstract class MouseAdapter implements MouseListener {
		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}
	}

	public static void main(String[] args) {
		new MouseEventFrame();
	}

}
